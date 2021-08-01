package at.aimrose.service.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import at.aimrose.service.main;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        //Player Abfrage
        if(!(sender instanceof Player)) {
            main.INSTANCE.log("§4Dazu musst du ein Spieler sein.");
            return true;
        }

        //Player = P
        Player p = (Player) sender;

        //Permission + Inhalt
        if(p.hasPermission("aimrose.chatclear") || p.hasPermission("aimrose.*")) {
            for (int i = 0; i < 105; ++i) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if(!all.hasPermission("aimrose.chatclear")) {
                        all.sendMessage("");
                    }
                }
            }
            Bukkit.broadcastMessage(main.PREFIX + "§7 Der Chat wurde von §e"+ p.getName() +"§7 geleert.");
            return true;

        }else{
            //No Perms
            p.sendMessage(main.PREFIX + "§7Dazu hast du keine Rechte.");
        }



        return false;
    }
}
