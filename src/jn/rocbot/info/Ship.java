package jn.rocbot.info;

import jn.rocbot.commands.Formatter;

public class Ship implements Formatter{
    public final String name;
    public final String weapon;
    public final String aura;
    public final String zen;

    public Ship(String name, String weapon, String aura, String zen) {
        this.name = name;
        this.weapon = weapon;
        this.aura = aura;
        this.zen = zen;
    }

    public String simpleToString(){
        return bold(name + ":") + " Weapon: " + italic(weapon) + ", Aura: " + italic(aura) + ", Zen: " + italic(zen);
    }
}
