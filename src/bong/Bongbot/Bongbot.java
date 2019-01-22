package bong.Bongbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import org.json.HTTP;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Bongbot {
    public static JDA jda;
    public static String prefix = "$";

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("NTM2OTI1MjQ0Mjc1ODE4NTE2.Dyd4YQ.KUTPif4f3AKQS2PNh_3DM3MUCWA").build();
        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setGame(Game.watching("Busy Bing Anime"));

        try {
            Bongbot.request();
        } catch (Exception e) {
            System.out.println("Error Fetching API");
        }

        jda.addEventListener(new Commands());
    }

    public static void request() throws Exception {
        String apikey = "?api_key=RGAPI-2c890ec8-768e-4040-b5ad-1b1123792253";
        String url = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/nick1590" + apikey;
        URL api = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) api.openConnection();
        connection.setRequestMethod("GET");
        //TODO requestproperty?
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

//        URL url = new URL("https://graph.facebook.com/search?q=java&type=post");
//        try (InputStream is = url.openStream();
//             JsonReader rdr = Json.createReader(is)) {
//
//                 JsonObject obj = rdr.readObject();
//                 JsonArray results = obj.getJsonArray("data");
//                 for (JsonObject result : results.getValuesAs(JsonObject.class)) {
//                         System.out.print(result.getJsonObject("from").getString("name"));
//                         System.out.print(": ");
//                         System.out.println(result.getString("message", ""));
//                         System.out.println("-----------");
//                     }
//             }

    }
}
