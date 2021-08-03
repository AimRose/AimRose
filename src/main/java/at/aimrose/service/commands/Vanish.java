package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class Vanish implements CommandExecutor {

    static ArrayList<Player> vanish = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("vanish")) {
                if (p.hasPermission("aimrose.vanish")) {
                    if(vanish.contains(p)) {
                        vanish.remove(p);
                        p.sendMessage(main.PREFIX + "§7Dein §eVanishmodus §7wurde erfolgreich deaktiviert.");

                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.showPlayer(p);
                        }

                    }else{
                        vanish.add(p);
                        p.sendMessage(main.PREFIX + "§7Dein §eVanishmodus §7wurde erfolgreich aktiviert.");

                        for(Player all : Bukkit.getOnlinePlayers()) {
                            all.hidePlayer(p);
                        }

                    }
                } else {
                    p.sendMessage(main.PREFIX + main.NOPERMS);
                }
            }

        }

        return false;
    }
}
