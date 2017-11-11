package jn.rocbot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
    private final static String HELP = "Usage: !help <whatever_comand_you_want_help_on>";
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

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
