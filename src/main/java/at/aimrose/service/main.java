package at.aimrose.service;

import at.aimrose.service.commands.*;
import at.aimrose.service.listner.GlobalMuteListener;
import at.aimrose.service.listner.JoinListener;
import at.aimrose.service.listner.MentationListener;
import at.aimrose.service.listner.PlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin implements Listener {

    //PREFIX
    public static String PREFIX = "§6§lNEOXSUCHT§8» ";
    public static String TeamPREFIX = "§d§lTEAM§8» ";
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
        getCommand("vanish").setExecutor(new Vanish());


        //Listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new GlobalMuteListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new PlayerChatListener(), this);
        pm.registerEvents(new MentationListener(), this);


    }

    @Override
    public void onDisable() {

        //Plugin is disable
        log("§4deaktiviert");
    }

    //ConsoleSender
    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }


}




