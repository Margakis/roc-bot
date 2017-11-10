package jn.rocbot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith("!") && !event.getMessage().getAuthor().isBot()){
            handleCommand(parser.parse(event.getMessage().getContent().toLowerCase()));
        }
    }
}
