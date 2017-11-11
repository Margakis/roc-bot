package jn.rocbot.commands;

import jn.rocbot.info.ShipStore;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Random;

public class ShipsCommand implements Command{
    private final static String HELP = ""; //TODO

    private final Random r = new Random();

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length > 0) {
            if (args[0].toLowerCase().equals("random")) {
                event.getTextChannel().sendMessage(ShipStore.SHIPS.get(r.nextInt(ShipStore.SHIPS.size())).simpleToString()).complete();
            }
        }
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
