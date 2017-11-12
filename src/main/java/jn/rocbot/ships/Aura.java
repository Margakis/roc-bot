package jn.rocbot.ships;

import java.util.HashMap;

public class Aura {
    public final String name;
    public final String description;
    public final String ultimateName;
    public final HashMap<String, String> properties;
    public final HashMap<String, String> ultimateProperties;

    public Aura(String name, String description, String ultimateName, HashMap<String, String> properties, HashMap<String, String> ultimateProperties) {
        this.name = name;
        this.description = description;
        this.ultimateName = ultimateName;
        this.properties = properties;
        this.ultimateProperties = ultimateProperties;
    }
}
