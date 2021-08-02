package at.aimrose.service;

import at.aimrose.service.commands.*;
import at.aimrose.service.listner.GlobalMuteListener;
import at.aimrose.service.listner.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin implements Listener {

    //PREFIX
    public static String PREFIX = "§d§lAIMROSE§8» ";
    //Wartung
    public static boolean wartung;
    //Main
    public static main INSTANCE;
    public Plugin plugin;

    public main() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        //Config
        Wartung.CreateConfig();
        //Plugin is enable
        log("§aaktiviert");

        //Register Event
        this.plugin = (Plugin) this;
        Bukkit.getServer().getPluginManager().registerEvents(this, (Plugin) this);

        //Commands
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("cc").setExecutor(new ChatClear());
        getCommand("chatclear").setExecutor(new ChatClear());
        getCommand("msg").setExecutor(new MSG());
        getCommand("globalmute").setExecutor(new Globalmute());
        getCommand("kick").setExecutor(new Kick());
        getCommand("wartung").setExecutor(new Wartung());
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("gamemode").setExecutor(new Gamemode());

        //Listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new GlobalMuteListener(), this);
        pm.registerEvents(new JoinListener(), this);


    }

    @Override
    public void onDisable() {

        //Plugin is disable
        log("§4deaktiviert");
    }

    //ConsoleSender
    public void log(String text) { Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }


    //Mentation

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();

        String[] words = msg.split(" ");

        for (int i = 0; i < words.length; i++) {
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.getName().equalsIgnoreCase(words[i])) {
                    words[i] = "§b@" + online.getName() + "§r";
                    online.playSound(online.getLocation(), Sound.BLOCK_NOTE_PLING, 3.0F, 1.0F);
                }
            }
        }

        String msgnew = "";

        for (int j = 0; j < words.length; j++) {
            msgnew = msgnew + words[j] + " ";
        }

        e.setMessage(msgnew);
    }
}



