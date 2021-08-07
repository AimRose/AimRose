package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class God implements CommandExecutor {

    public static ArrayList<String> god = new ArrayList<String>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("aimrose.god")) {
            if (args.length == 0) {
                if(god.contains(p.getName())) {
                    god.remove(p.getName());
                    p.sendMessage(main.PREFIX + "§7Dein Godmodus wurde deaktiviert.");
                }else {
                    god.add(p.getName());
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage(main.PREFIX + "§7Dein Godmodus wurde aktiviert.");
                }

            } else {
                p.sendMessage(main.PREFIX + "§7Bitte benutze /god.");
            }
        } else {
            p.sendMessage(main.PREFIX + main.NOPERMS);
        }


        return false;
    }
}
