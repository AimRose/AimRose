package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if (s instanceof Player) {
            Player p = (Player) s;
            if (p.hasPermission("aimrose.gamemode")) {
                if (args.length == 0) {
                    p.sendMessage(main.PREFIX + "§7Bentuze bitte /gm 0 | 1 | 2 | 3 [Spieler]");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {

                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(main.PREFIX + "§7Spielmodus §eÜberlebenmodus §7für §e" + p.getName() + "§7 gesetzt.");

                    } else if (args[0].equalsIgnoreCase("1")) {

                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(main.PREFIX + "§7Spielmodus §eKreativmodus §7für §e" + p.getName() + "§7 gesetzt.");

                    } else if (args[0].equalsIgnoreCase("2")) {

                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(main.PREFIX + "§7Spielmodus §eAbenteuermodus §7für §e" + p.getName() + "§7 gesetzt.");

                    } else if (args[0].equalsIgnoreCase("3")) {

                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(main.PREFIX + "§7Spielmodus §eZuschauermodus §7für §e" + p.getName() + "§7 gesetzt.");

                    } else {
                        p.sendMessage(main.PREFIX + "§7Bentuze bitte /gm 0 | 1 | 2 | 3 [Spieler]");
                    }
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        if (args[0].equalsIgnoreCase("0")) {

                            p.sendMessage(main.PREFIX + "§7Du hast den Spieler §e" + target.getName() + " §7in den §eÜberlebenmodus §7gesetzt.");
                            target.setGameMode(GameMode.SURVIVAL);
                            target.sendMessage(main.PREFIX + "§7Spielmodus §eÜberlebenmodus §7für §e" + p.getName() + "§7gesetzt.");

                        } else if (args[0].equalsIgnoreCase("1")) {

                            p.sendMessage(main.PREFIX + "§7Du hast den Spieler §e" + target.getName() + " §7in den §eKreativmodus §7gesetzt.");
                            target.setGameMode(GameMode.CREATIVE);
                            target.sendMessage(main.PREFIX + "§7Spielmodus §eKreativmodus §7für §e" + p.getName() + "§7gesetzt.");

                        } else if (args[0].equalsIgnoreCase("2")) {

                            p.sendMessage(main.PREFIX + "§7Du hast den Spieler §e" + target.getName() + " §7in den §eAbenteuermodus §7gesetzt.");
                            target.setGameMode(GameMode.ADVENTURE);
                            target.sendMessage(main.PREFIX + "§7Spielmodus §eAbenteuermodus §7für §e" + p.getName() + "§7gesetzt.");

                        } else if (args[0].equalsIgnoreCase("3")) {

                            p.sendMessage(main.PREFIX + "§7Du hast den Spieler §e" + target.getName() + " §7in den §eZuschauermodus §7gesetzt.");
                            target.setGameMode(GameMode.SPECTATOR);
                            target.sendMessage(main.PREFIX + "§7Spielmodus §eZuschauermodus §7für §e" + p.getName() + "§7gesetzt.");

                        } else {
                            p.sendMessage(main.PREFIX + "§7Bentuze bitte /gm 0 | 1 | 2 | 3 [Spieler]");
                        }
                    } else {
                        p.sendMessage(main.PREFIX + "§7Der Spieler §e" + args[1] + " §7ist nicht online.");
                    }

                } else {
                    p.sendMessage(main.PREFIX + "§7Bentuze bitte /gm 0 | 1 | 2 | 3 [Spieler]");
                }

            } else {
                p.sendMessage(main.PREFIX + "§7Dazu hast du keine Rechte.");
            }
        }


        return false;
    }
}
