package at.aimrose.service;

import at.aimrose.service.commands.*;
import at.aimrose.service.listner.*;
import at.aimrose.service.perks.InvDeathListener;
import at.aimrose.service.perks.NoHungerListener;
import at.aimrose.service.perks.XpDeathListener;
import at.aimrose.service.stoarge.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    //PREFIX
    public static String PREFIX = "§6§lNEOXSUCHT§8» ";
    public static String TeamPREFIX = "§d§lTEAM§8» ";
    public static String NOPERMS = "§7Dazu hast du keine Rechte!";
    //Wartung
    public static boolean wartung;
    //Main
    public static Main INSTANCE;
    public Plugin plugin;

    public Main() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        this.saveDefaultConfig();
        MySQL.username = this.getConfig().getString("MySQL.username");
        MySQL.port = this.getConfig().getString("MySQL.port");
        MySQL.host = this.getConfig().getString("MySQL.host");
        MySQL.database = this.getConfig().getString("MySQL.database");
        MySQL.password = this.getConfig().getString("MySQL.password");
        MySQL.connect();
        MySQL.createTable();
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
        getCommand("Clearlag").setExecutor(new ClearLag());
        getCommand("enderchest").setExecutor(new Enderchest());
        getCommand("ec").setExecutor(new Enderchest());
        getCommand("perks").setExecutor(new InventoryCommand());


        //Listener
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new GlobalMuteListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new PlayerChatListener(), this);
        pm.registerEvents(new MentationListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new NoHungerListener(), this);
        pm.registerEvents(new XpDeathListener(), this);
        pm.registerEvents(new InvDeathListener(), this);


    }

    @Override
    public void onDisable() {
        MySQL.close();

        //Plugin is disable
        log("§4deaktiviert");
    }

    //ConsoleSender
    public void log(String text) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }


}




