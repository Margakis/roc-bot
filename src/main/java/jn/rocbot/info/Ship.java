package jn.rocbot.info;

import jn.rocbot.commands.Formatter;

public class Ship implements Formatter{
    public final String name;
    public final String weapon;
    public final String aura;
    public final String zen;
    public final RARITY rarity;

    public Ship(String name, String weapon, String aura, String zen, RARITY rarity) {
        this.name = name;
        this.weapon = weapon;
        this.aura = aura;
        this.zen = zen;
        this.rarity = rarity;
    }

    public String simpleToString(){
        return rarity.toEmoji() + " " + bold(name + ":") + " Weapon: " + italic(weapon) + ", Aura: " + italic(aura) + ", Zen: " + italic(zen);
    }

    public enum RARITY{
        COMMON("<:common:378807923318718464>"),
        RARE("<:rare:378807923377307648>"),
        SUPER_RARE("<:superrare:378808209709858819>");

        private final String emoji;

        public String toEmoji(){
            return this.emoji;
        }

        public static String fromInt(int i) throws ArrayIndexOutOfBoundsException{
            switch(i){
                case 1:
                    return "COMMON";
                case 2:
                    return "RARE";
                case 3:
                    return "SUPER_RARE";
            }
            throw new ArrayIndexOutOfBoundsException("The rarity must be from 1 - 3 not: " + i);
        }

        RARITY(String s) {
            this.emoji = s;
        }
    }

    public static boolean isShip(String name){
        try {
            return ShipStore.getShip(name) != null;
        } catch (ShipNotFoundException e) {
            return false;
        }
    }
}
