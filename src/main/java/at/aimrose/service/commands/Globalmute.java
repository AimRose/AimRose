package at.aimrose.service.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import at.aimrose.service.main;

public class Globalmute implements CommandExecutor {

    public static boolean globalmute = true;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage("§4Dazu musst du ein Spieler sein.");
        }else{
            Player p = (Player) sender;

            if(!(p.hasPermission("system.globalmute") || (p.hasPermission("system.*")))) {
                p.sendMessage("§4Error§8» §7Für diesen Command brauchst du die Permission §esystem.globalmute !");
                return true;
            }
            if(globalmute) {
                globalmute = false;
                p.sendMessage(main.PREFIX + "§7Der Chat wurde von §e " + sender.getName() + "§7 aktiviert");
            }else{
                globalmute =  true;
                p.sendMessage(main.PREFIX + "§7Der Chat wurde von §e " + sender.getName() + "§7 deaktiviert");
            }

        }



        return false;
    }
}