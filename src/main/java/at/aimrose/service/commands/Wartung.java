package at.aimrose.service.commands;

import at.aimrose.service.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Wartung implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (p.hasPermission("aimrose.wartung")) {
                if (Main.wartung == true) {
                    setWartung(false);
                    Main.wartung = false;
                    p.sendMessage(Main.PREFIX + "§7Der Wartungsmodus wurde deaktiviert. ");
                } else {
                    setWartung(true);
                    Main.wartung = true;
                    p.sendMessage(Main.PREFIX + "§7Der Wartungsmodus wurde aktiviert.");
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
            }
        } else {
            //Console
            if (Main.wartung == true) {
                setWartung(false);
                Main.wartung = false;
                s.sendMessage(Main.PREFIX + "§7Der Wartungsmodus wurde deaktiviert. ");
            } else {
                setWartung(true);
                Main.wartung = true;
                s.sendMessage(Main.PREFIX + "§7Der Wartungsmodus wurde aktiviert.");
            }
        }

        return false;
    }

    public static void CreateConfig() {
        File f = new File("plugins/AimRose/wartung.yml");
        YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(f);
        if (f.exists()) {
            Main.wartung = cfg.getBoolean("aimrose.wartung");
        } else {
            cfg.set("aimrose.wartung", false);
            try {
                cfg.save(f);
            } catch (IOException e) {

                e.printStackTrace();
            }
            Main.wartung = false;
        }
    }

    public static void setWartung(boolean wartung) {
        File f = new File("plugins/AimRose/wartung.yml");
        YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(f);
        cfg.set("aimrose.wartung", wartung);

        try {
            cfg.save(f);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
