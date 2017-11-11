package jn.rocbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Main {

    //<editor-fold desc="ANSI codes">
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //</editor-fold>
    private static boolean DEBUG;

    private static net.dv8tion.jda.core.JDA JDA;

    public static void main(String[] args){
        try {
            JDA = new JDABuilder(AccountType.BOT).addEventListener(new Bot()).setToken(args[0]).buildBlocking();
            JDA.setAutoReconnect(true);
        } catch (Exception e){
            e.printStackTrace();
        }

        if(DEBUG = /*Boolean.valueOf(args[1])*/ false);
    }

    public enum LOGTYPE {
        INFO,
        ERROR,
        DEBUG;
    }

    public static void log(LOGTYPE type, String message){
        switch (type){
            case INFO:
                System.out.println(ANSI_PURPLE + message + ANSI_RESET);
                break;
            case ERROR:
                System.out.println(ANSI_RED + message + ANSI_RESET);
                break;
            case DEBUG:
                if(Main.DEBUG)
                    System.out.println(ANSI_YELLOW + message + ANSI_RESET);
                break;
        }
    }
}
