package bong.Bongbot;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void recievedmsg(GuildMessageReceivedEvent event) {
        System.out.println(event.getMessage().getContentRaw() + "hello");
        String[] msgDiv = event.getMessage().getContentRaw().split(" ");
        if (msgDiv[0].equalsIgnoreCase(Bongbot.prefix)) {
            event.getChannel().sendTyping().queue();
            switch (msgDiv[1]) {
                case "bong":
                    event.getChannel().sendMessage("Challenger").queue();
                    break;
                case "nick":
                    break;
                default:
                    event.getChannel().sendMessage("You retard that's not a command").queue();
            }
        }
    }
}
