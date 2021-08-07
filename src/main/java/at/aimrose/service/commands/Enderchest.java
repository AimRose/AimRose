package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Enderchest implements CommandExecutor {


    public static ArrayList<UUID> enderchest = new ArrayList();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Dazu musst du ein Spieler sein.");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("aimrose.enderchest")) {
            p.sendMessage(main.PREFIX + main.NOPERMS);
            return true;
        }

        if(args.length == 0) {
            p.openInventory(p.getEnderChest());
        }  else if(args.length == 1) {
            if(!p.hasPermission("aimrose.enderchest.other")) {
                p.sendMessage(main.PREFIX + main.NOPERMS);
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                p.sendMessage(main.PREFIX + "§7Der Spieler §e" + args[0] + " §7ist nicht online.");
                return true;
            }
            p.openInventory(target.getEnderChest());
            p.sendMessage(main.PREFIX + "§7Du schaust nun in die Enderchest von §e " + target.getName() + "§7.");
            enderchest.contains(p.getUniqueId());
        } else {
            p.sendMessage(main.PREFIX + "§7Bitte benutze /enderchest [Spieler]");
        }


        return false;
    }
}
