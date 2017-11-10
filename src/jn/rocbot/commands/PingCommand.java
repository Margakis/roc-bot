package jn.rocbot.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PingCommand implements Command {
    private final String HELP = "Usage: \"!ping\"";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Pong!")
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
