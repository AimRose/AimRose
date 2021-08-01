package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("aimrose.heal") || (player.hasPermission("aimrose.*"))) {
                if (args.length == 0) {
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.sendMessage(main.PREFIX + "§7Du wurdest geheilt.");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage(main.PREFIX + "§7Du wurdest geheilt.");
                        player.sendMessage(main.PREFIX + "§7Du hast den Spieler §e" + target.getName() + " §7geheilt.");
                    } else
                        player.sendMessage(main.PREFIX + "§7Der Spieler §e" + args[0] + " §7ist nicht online.");
                }else
                    player.sendMessage(main.PREFIX + "§7Bitte benutze /heal [Spieler].");
            } else
                player.sendMessage(main.PREFIX + "§7Dazu hast du keine Rechte.");
        } else
            sender.sendMessage("§4Du musst ein Spieler sein für diesen Command.");

        return false;
    }
}

