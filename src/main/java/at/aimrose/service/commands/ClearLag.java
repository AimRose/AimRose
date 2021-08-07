package at.aimrose.service.commands;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

public class ClearLag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender.hasPermission("aimrose.clearlag")) {
            for (Entity entity : Bukkit.getWorld("world").getEntities()) {
                if (entity instanceof Item) {
                    entity.remove();
                }
            }
            sender.sendMessage(main.PREFIX + "§7Alle Gegenstände am Boden wurden entfernt.");
        } else {
            sender.sendMessage(main.PREFIX + main.NOPERMS);
        }

        return false;
    }
}
