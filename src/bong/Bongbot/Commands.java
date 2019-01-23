package bong.Bongbot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
                case "playlist":
                    switch (args[2]) {
                        case "add":
                            break;
                        case "remove":
                            break;
                        case "show":
                    }
                    break;
                case "help":
                    break;
                case "league":
                    String base = "http://na.op.gg/summoner/userName=";
                    event.getChannel().sendMessage(base + args[2]).queue();
                    break;
                case "summonor":
                    try {
                        String summonor = request("/lol/summoner/v4/summoners/by-name/", args[2]);
                        System.out.println(args[2]);
                        event.getChannel().sendMessage(summonor).queue();
                    } catch (Exception e) {
                        System.out.println("Error Fetching API");
                    }
                    break;
                default:
                    event.getChannel().sendMessage("You retard that's not a command").queue();
            }
        }
    }

    public static String request(String requesttype, String requestarg) throws Exception {
        String base = "https://na1.api.riotgames.com";
        String apikey = "?api_key=RGAPI-916a8234-ce8f-4c04-b6c5-efef3fb24620";
        String url = base + requesttype + requestarg + apikey;
        System.out.println(url);
        URL api = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) api.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine = bufferedReader.readLine();
        StringBuffer response = new StringBuffer();
        while (inputLine != null) {
            response.append(inputLine);
            inputLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        System.out.println(response.toString());
        JSONObject jsonObject = new JSONObject(response.toString());
        System.out.println("3");
        System.out.println(jsonObject.getString("name"));

        return jsonObject.getString("name");
    }
}