package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("aimrose.kick")) {
                if (args.length == 0) {
                    p.sendMessage(main.PREFIX + "§7Bitte benutze /kick [Name] [Grund]");
                } else if (args.length == 1) {
                    p.sendMessage(main.PREFIX + "§7Bitte benutze /kick [Name] [Grund]");
                } else {
                    Player t = Bukkit.getPlayer(args[0]);
                    if (t != null) {
                        StringBuilder sb = new StringBuilder();
                        for(int i = 1; i < args.length; i++) {
                            if(i != 0) {
                                sb.append(' ');
                            }
                            sb.append(args[i]);
                        }
                        String grund = sb.toString();
                        t.kickPlayer("§c§lGEKICKT \n\n"
                                + "§eVon:§7 " + sender.getName() + "\n"
                                + "§eGrund:§7" +grund);

                        p.sendMessage(main.PREFIX + "§7Der Spieler §e" + t.getName() + " §7wurde gekickt mit dem Grund: §e" +grund);
                    } else {
                        p.sendMessage(main.PREFIX + "§7Der Spieler §e" + args[0] + " §7ist nicht online.");
                    }
                }


            } else {
                p.sendMessage(main.PREFIX + "§7Dazu hast du keine Rechte.");
            }
        } else {
            Player t = Bukkit.getPlayer(args[0]);
            if (t != null) {
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < args.length; i++) {
                    if(i != 0) {
                        sb.append(' ');
                    }
                    sb.append(args[i]);
                }
                String grund = sb.toString();
                t.kickPlayer("§c§lGEKICKT \n\n"
                        + "§eVon:§7 " + sender.getName() + "\n"
                        + "§eGrund:§7" +grund);
                sender.sendMessage(main.PREFIX + "§7Der Spieler §e" + t.getName() + " §7wurde gekickt mit dem Grund: §e" +grund);
            } else {
                sender.sendMessage(main.PREFIX + "§7Der Spieler §e" + args[0] + " §7ist nicht online.");
            }
        }

        return false;
    }
}
