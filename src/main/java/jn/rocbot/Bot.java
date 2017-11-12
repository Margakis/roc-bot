package jn.rocbot;

import jn.rocbot.commands.Command;
import jn.rocbot.commands.ShipsCommand;
import jn.rocbot.commands.SourceCommand;
import jn.rocbot.commands.testcommands.HelloCommand;
import net.dv8tion.jda.core.events.DisconnectEvent;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Random;

public class Bot extends ListenerAdapter {
    private final Random r = new Random();
    public static HashMap<String, Command> COMMANDS;

    public static RocParser PARSER;

    static {
        PARSER = new RocParser();

        COMMANDS = new HashMap<String, Command>();
        COMMANDS.put("hello", new HelloCommand());
        COMMANDS.put("ships", new ShipsCommand());
        COMMANDS.put("source", new SourceCommand());
    }

    private void dlog(String msg){
        Main.log(Main.LOGTYPE.DEBUG, msg);
    }
    private void vlog(String msg){
        Main.log(Main.LOGTYPE.VERBOSE, msg);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        vlog("MessageRecieved!: "+event.getMessage().getContent()
                + "\nFrom user: " + event.getMessage().getAuthor().getName() + ", isbot: " +event.getMessage().getAuthor().isBot());

        if(event.getMessage().getContent().startsWith("!") && !event.getMessage().getAuthor().isBot()){
            dlog("Recieved message starting with \"!\": " + event.getMessage().getContent());
            handleCommand(PARSER.parse(event.getMessage().getContent().toLowerCase(), event));
        }else {
            if(!event.getAuthor().isBot()) {
                String raw = event.getMessage().getContent().toLowerCase();
                if (raw.contains("name the bot")) {
                    event.getTextChannel().sendMessage("No " + Emojis.EL).complete();
                } else if (raw.contains("thanks bot")) {
                    String str = "";

                    if (r.nextInt(10) == 1) str = " Glad to be of use";
                    event.getTextChannel().sendMessage("No problem! ^^" + str).complete();
                } else if (raw.contains("best") && raw.contains("game")) {
                    event.getTextChannel().sendMessage("Best game is **Reassembly of course**! " + Emojis.EL).complete();
                }
            }
        }
    }

    @Override
    public void onReady(ReadyEvent event){
        Main.log(Main.LOGTYPE.INFO, "Logged in as " + event.getJDA().getSelfUser().getName());
        Main.log(Main.LOGTYPE.INFO, "Name set to Roc-bot");
        Main.JDA.getSelfUser().getManager().setName("Roc-bot").complete();
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
