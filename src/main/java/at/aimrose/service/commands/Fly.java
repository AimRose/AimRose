package at.aimrose.service.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import at.aimrose.service.main;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("aimrose.fly") || (player.hasPermission("aimrose.*"))) {
                if (args.length == 0) {
                    if (player.getAllowFlight()) {
                        player.sendMessage(main.PREFIX + "§7Dein Flugmodus wurde deaktiviert.");
                        player.setAllowFlight(false);
                        player.setFlying(false);
                    } else {
                        player.sendMessage(main.PREFIX + "§7Dein Flugmodus wurde aktiviert.");
                        player.setAllowFlight(true);
                        player.setFlying(true);
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if (player.getAllowFlight()) {
                            target.sendMessage(main.PREFIX + "§7Dein Flugmodus wurde deaktiviert.");
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            player.sendMessage(main.PREFIX + "§7Du hast den Flugmodus von §e" + target.getName() + " §7deaktiviert.");
                        } else {
                            target.sendMessage(main.PREFIX + "§7Dein Flugmodus wurde aktiviert.");
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            player.sendMessage(main.PREFIX + "§7Du hast den Flugmodus von §e" + target.getName() + " §7aktiviert.");
                        }
                    } else
                        player.sendMessage(main.PREFIX + "§7Der Spieler §e" + args[0] + " §7ist nicht online.");
                } else
                    player.sendMessage(main.PREFIX + "§7Bitte benutze /fly [Spieler].");
            } else
                player.sendMessage(main.PREFIX + "§7Dazu hast du keine Rechte.");
        } else
            sender.sendMessage("§4Du musst ein Spieler sein für diesen Command.");


        return false;
    }
}
