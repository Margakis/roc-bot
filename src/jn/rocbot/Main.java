package jn.rocbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Main {
    private static net.dv8tion.jda.core.JDA JDA;

    public static void main(String[] args){
        try{
            JDA = new JDABuilder(AccountType.BOT).addEventListener(new Bot()).setToken(args[0]).buildBlocking();
            JDA.setAutoReconnect(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
