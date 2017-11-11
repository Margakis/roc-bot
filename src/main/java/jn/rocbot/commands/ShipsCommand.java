package jn.rocbot.commands;

import jn.rocbot.Emojis;
import jn.rocbot.Main;
import jn.rocbot.info.Ship;
import jn.rocbot.info.ShipNotFoundException;
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
                if(args.length > 1) {
                    if(isInteger(args[1])){
                        String list = "";
                        int num = Integer.valueOf(args[1]);

                        if( num > 50) {
                            num = 50;
                            list += "Can not list more than 50 ships!\n";
                        }

                        for(int i = 0; i < num; i++){
                            list += ShipStore.SHIPS.get(r.nextInt(ShipStore.SHIPS.size())).simpleToString() + "\n";
                        }

                        event.getTextChannel().sendMessage(list).complete();

                    }else {
                        if (args[1].toLowerCase().equals("info"))
                            event.getTextChannel().sendMessage(ShipStore.SHIPS.get(r.nextInt(ShipStore.SHIPS.size())).simpleToString()).complete();
                    }
                }else{
                    int ship = r.nextInt(ShipStore.SHIPS.size());
                    event.getTextChannel().sendMessage("**" + ShipStore.SHIPS.get(ship).name + "** " + ShipStore.SHIPS.get(ship).rarity.toEmoji()).complete();
                }
            }

            else if(Ship.isShip(args[0])){
                dlog("");
                try {
                    event.getTextChannel().sendMessage(ShipStore.getShip(args[0]).simpleToString());
                } catch (ShipNotFoundException e) {

                }
            }
        }else{
            String shiplist = "";

            for(Ship ship : ShipStore.SHIPS){
                if(ship.name != "Shogun") shiplist += ship.name + ", ";
                else shiplist += "Shogun";
            }

            event.getTextChannel().sendMessage(shiplist).complete();
        }
    }

    public boolean isInteger(String str) {
        int size = str.length();

        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return size > 0;
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public boolean executed(boolean success, MessageReceivedEvent event) {
        return true;
    }

    private void dlog(String msg){
        Main.log(Main.LOGTYPE.DEBUG, msg);
    }
}
