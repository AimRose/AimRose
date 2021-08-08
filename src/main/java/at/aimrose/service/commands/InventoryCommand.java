package at.aimrose.service.commands;

import at.aimrose.service.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return false;

        Player p = (Player) sender;
        Inventory inventory = Bukkit.createInventory(null, 3*9, "§b§LPerks");
        inventory.setItem(0, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(1, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(2, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(3, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(4, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(5, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(6, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(7, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(8, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.COOKED_BEEF).setDisplayname("§eKein Hunger").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(10, new ItemBuilder(Material.SUGAR).setDisplayname("§eSchnelligkeit").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(11, new ItemBuilder(Material.DIAMOND_AXE).setDisplayname("§eStärke").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(13, new ItemBuilder(Material.GOLD_PICKAXE).setDisplayname("§eSchneller Abbauen").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(14, new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§eLeuchten").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(15, new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§eXP nach dem Tod behalten").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(16, new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§eInventar nach dem Tod behalten").setLore("§7Klicke zum aktivieren/deaktivieren.").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(18, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(19, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(20, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(21, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(22, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(23, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(24, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(25, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());
        inventory.setItem(26, new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build());


        p.openInventory(inventory);
        return false;
    }
}
