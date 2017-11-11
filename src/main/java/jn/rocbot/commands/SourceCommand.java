package jn.rocbot.commands;

import net.dv8tion.jda.core.entities.impl.MessageEmbedImpl;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class SourceCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new MessageEmbedImpl()
                        .setColor(Color.RED)
                        .setTitle("Roc-bot github source")
                        .setUrl("https://github.com/Jens0512/roc-bot")
        );
    }

    @Override
    public String help() {
        return "Usage: !source";
    }

    @Override
    public boolean executed(boolean success, MessageReceivedEvent event) {
        return false;
    }
}
