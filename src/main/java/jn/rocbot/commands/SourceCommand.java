package jn.rocbot.commands;

import net.dv8tion.jda.core.entities.EmbedType;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.impl.MessageEmbedImpl;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.OffsetDateTime;
import java.util.List;

public class SourceCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    // "Roc-bot github source" "https://github.com/Jens0512/roc-bot"

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new MessageEmbedImpl()
                    .setUrl("https://github.com/Jens0512/roc-bot")
                    .setTitle("Roc-bots innards!")
                    .setDescription("Roc-bot github source")
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
