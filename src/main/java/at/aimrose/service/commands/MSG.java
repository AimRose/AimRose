package at.aimrose.service.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import at.aimrose.service.main;

public class MSG implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

        String msg2 = "";

        Player p = (Player) cs;
        if (cs instanceof Player) {
            if (p.hasPermission("aimrose.msg") || p.hasPermission("aimrose.*")) {
                if (args.length >= 2) {
                    Player t = Bukkit.getPlayer(args[0]);

                    try {
                        for (int msg = 1; msg < args.length; msg++) {
                            msg2 = String.valueOf(msg2) + args[msg] + " ";
                        }
                        if (p != t) {
                            t.sendMessage(String.valueOf(main.PREFIX.replaceAll("&", "§")) + "§6[§c" + p.getName() + " §6-> §cDu§6]§f" + msg2);
                            p.sendMessage(String.valueOf(main.PREFIX.replaceAll("&", "§")) + "§6[§cDu §6-> §c" + t.getName() + "§6]§f" + msg2);
                        } else {
                            p.sendMessage(String.valueOf(main.PREFIX.replaceAll("&", "§")) + "§7Du kannst dir selber nicht schreiben!");
                        }
                        msg2 = " ";
                    } catch (Exception e) {


                        p.sendMessage(String.valueOf(main.PREFIX.replaceAll("&", "§")) + "§7Der Spieler §e" + args[0] + " §7ist nicht online.");
                    }

                } else {

                    p.sendMessage(String.valueOf(main.PREFIX.replaceAll("&", "§")) + "§7Bitte benutze /msg [Spieler] [Nachricht]§7.");
                }
            }
        } else {

            cs.sendMessage("Du musst ein Spieler sein.");
        }

        return false;
    }
}
