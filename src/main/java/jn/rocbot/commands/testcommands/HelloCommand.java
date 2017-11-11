package jn.rocbot.commands.testcommands;

import jn.rocbot.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelloCommand implements Command {
    private final static String HELP = "Usage: !Hello";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Hello! hi jen").complete();
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public boolean executed(boolean success, MessageReceivedEvent event) {
        return true;
    }
}
