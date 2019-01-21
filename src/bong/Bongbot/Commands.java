package bong.Bongbot;

//import net.dv8tion.jda.core.EmbedBuilder;
//import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
//import net.dv8tion.jda.core.hooks.ListenerAdapter;
//
//public class Commands extends ListenerAdapter {
//
//    public void recieveMsg(GuildMessageReceivedEvent event) {
//        System.out.println(event.getMessage().getContentRaw() + "hello");
//        String[] msgDiv = event.getMessage().getContentRaw().split(" ");
//        if (msgDiv[0].equalsIgnoreCase(Bongbot.prefix)) {
//
//            EmbedBuilder embedBuilder = new EmbedBuilder();
//            embedBuilder.setTitle("Bongbot info");
//            embedBuilder.setDescription("Weeb bot");
//            embedBuilder.addField("Creator", "Bong", false);
//            embedBuilder.setColor(0x92f441);
//
//            event.getChannel().sendTyping().queue();
//            event.getChannel().sendMessage(embedBuilder.build()).queue();
//            embedBuilder.clear();
//
//            switch (msgDiv[1]) {
//                case "bong":
//                    event.getChannel().sendMessage("Challenger").queue();
//                    break;
//                case "nick":
//                    break;
//                default:
//                    event.getChannel().sendMessage("You retard that's not a command").queue();
//            }
//        }
//    }
//}

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        System.out.println(args[0] + " " + Bongbot.prefix + " " + args[1]);
        if (args[0].equalsIgnoreCase(Bongbot.prefix)) {
            switch (args[1]) {
                case "bong":
                    event.getChannel().sendMessage("Challenger").queue();
                    break;
                case "info":
                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setTitle("Bongbot info");
                    embedBuilder.setDescription("Weeb bot");
                    embedBuilder.addField("Creator", "Bong", false);
                    embedBuilder.setColor(0x92f441);
                    embedBuilder.setFooter("Created by Bong", event.getMember().getUser().getAvatarUrl());

                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessage(embedBuilder.build()).queue();
                    embedBuilder.clear();
                    break;
                default:
                    event.getChannel().sendMessage("You retard that's not a command").queue();
            }
        }
    }
}