package at.aimrose.service.commands;

import at.aimrose.service.main;
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
                if (main.wartung == true) {
                    setWartung(false);
                    main.wartung = false;
                    p.sendMessage(main.PREFIX + "§7Der Wartungsmodus wurde deaktiviert. ");
                } else {
                    setWartung(true);
                    main.wartung = true;
                    p.sendMessage(main.PREFIX + "§7Der Wartungsmodus wurde aktiviert.");
                }
            } else {
                p.sendMessage(main.PREFIX + "§7Dazu hast du keine Rechte.");
            }
        } else {
            //Console
            if (main.wartung == true) {
                setWartung(false);
                main.wartung = false;
                s.sendMessage(main.PREFIX + "§7Der Wartungsmodus wurde deaktiviert. ");
            } else {
                setWartung(true);
                main.wartung = true;
                s.sendMessage(main.PREFIX + "§7Der Wartungsmodus wurde aktiviert.");
            }
        }

        return false;
    }

    public static void CreateConfig() {
        File f = new File("plugins/AimRose/wartung.yml");
        YamlConfiguration cfg = new YamlConfiguration().loadConfiguration(f);
        if (f.exists()) {
            main.wartung = cfg.getBoolean("aimrose.wartung");
        } else {
            cfg.set("aimrose.wartung", false);
            try {
                cfg.save(f);
            } catch (IOException e) {

                e.printStackTrace();
            }
            main.wartung = false;
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
