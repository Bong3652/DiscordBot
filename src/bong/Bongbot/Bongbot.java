package bong.Bongbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class Bongbot {
    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken
                ("NTM2OTI1MjQ0Mjc1ODE4NTE2.Dyd4YQ.KUTPif4f3AKQS2PNh_3DM3MUCWA").build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setGame(Game.watching("Watching Anime"));
    }
}
