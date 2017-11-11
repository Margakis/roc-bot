package jn.rocbot;

import jn.rocbot.commands.Command;
import jn.rocbot.commands.ShipsCommand;
import jn.rocbot.commands.SourceCommand;
import jn.rocbot.commands.testcommands.HelloCommand;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.HashMap;

public class Bot extends ListenerAdapter{

    public static HashMap<String, Command> COMMANDS;

    public static RocParser PARSER;

    static {
        PARSER = new RocParser();

        COMMANDS = new HashMap<>();
        COMMANDS.put("hello", new HelloCommand());
        COMMANDS.put("ships", new ShipsCommand());
        COMMANDS.put("source", new SourceCommand());
    }

    private void dlog(String msg){
        Main.log(Main.LOGTYPE.DEBUG, msg);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        dlog("MessageRecieved!: "+event.getMessage().getContent()
                + "\nFrom user;" + event.getMessage().getAuthor().getName() + ", isbot: " +event.getMessage().getAuthor().isBot());
        if(event.getMessage().getContent().startsWith("!") && !event.getMessage().getAuthor().isBot()){
            dlog("Recieved message starting with \"!\": " + event.getMessage().getContent());
            handleCommand(PARSER.parse(event.getMessage().getContent().toLowerCase(), event));
        }
    }

    @Override
    public void onReady(ReadyEvent event){
        Main.log(Main.LOGTYPE.INFO, "Logged in as " + event.getJDA().getSelfUser().getName());
    }

    private void handleCommand(RocParser.CommandContainer cmd){
        dlog(cmd.hrInfo());
        if(COMMANDS.containsKey(cmd.invoke)){
            boolean safe = COMMANDS.get(cmd.invoke).called(cmd.args, cmd.event);

            if(safe){
                COMMANDS.get(cmd.invoke).action(cmd.args, cmd.event);
                COMMANDS.get(cmd.invoke).executed(true, cmd.event);
            }else{
                COMMANDS.get(cmd.invoke).executed(false, cmd.event);
            }
        }
    }
}
