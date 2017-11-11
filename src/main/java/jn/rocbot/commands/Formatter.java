package jn.rocbot.commands;

public interface Formatter {
    public default String italic(String s){
        return "*" + s + "*";
    }

    public default String bold(String s){
        return "**" + s + "**";
    }
}
