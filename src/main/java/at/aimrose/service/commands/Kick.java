package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission("aimrose.kick")) {
                if(args.length == 1) {
                    p.sendMessage(main.PREFIX + "§7Bitte benutze /kick [Name] [Grund]");
                }else if{
                }
            }
        }

        return false;
    }
}
