package bong.Bongbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import org.json.JSONObject;

import java.io.BufferedReader;
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


        jda.addEventListener(new Commands());
    }

}
