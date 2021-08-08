package at.aimrose.service.listner;

import at.aimrose.service.Main;
import at.aimrose.service.perks.Perk;
import at.aimrose.service.perks.PerkManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle() == "§b§LPerks") {
            e.setCancelled(true);
            if (p.hasPermission("perks.hunger")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eKein Hunger") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.NO_HUNGER, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.NO_HUNGER));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.NO_HUNGER)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eKein Hunger §7Perk aktiviert.");
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eKein Hunger §7Perk deaktiviert.");
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
            if (p.hasPermission("perks.speed")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eSchnelligkeit") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.SPEED, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.SPEED));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.SPEED)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eSchnelligkeit §7Perk aktiviert.");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 1));
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eSchnelligkeit §7Perk deaktiviert.");
                        p.removePotionEffect(PotionEffectType.SPEED);
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
            if (p.hasPermission("perks.stärke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eStärke") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.Strength, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.Strength));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.Strength)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eStärke §7Perk aktiviert.");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, 0));
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eStärke §7Perk deaktiviert.");
                        p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
            if (p.hasPermission("perks.haste")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eSchneller Abbauen") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.HASTE, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.HASTE));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.HASTE)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eSchneller Abbauen §7Perk aktiviert.");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 100000, 1));
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eSchneller Abbauen §7Perk deaktiviert.");
                        p.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
            if (p.hasPermission("perks.leuchten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eLeuchten") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.GLOWING, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.GLOWING));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.GLOWING)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eLeuchten §7Perk aktiviert.");
                        p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eLeuchten §7Perk deaktiviert.");
                        p.removePotionEffect(PotionEffectType.GLOWING);
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
            if (p.hasPermission("perks.keepxp")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eXP nach dem Tod behalten") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.KEEP_XP, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.KEEP_XP));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.KEEP_XP)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eXP nach dem Tod behalten §7Perk aktiviert.");
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eXP nach dem Tod behalten §7Perk deaktiviert.");
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
            if (p.hasPermission("perks.keepinv")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() == "§eInventar nach dem Tod behalten") {
                    PerkManager.updatePlayerPerkState(p.getUniqueId(), Perk.KEEP_INVENTORY, !PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.KEEP_INVENTORY));
                    if (PerkManager.getPlayerPerkStates(p.getUniqueId()).contains(Perk.KEEP_INVENTORY)) {
                        // deaktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eInventar nach dem Tod behalten §7Perk aktiviert.");
                    } else {
                        // aktivieren
                        p.sendMessage(Main.PREFIX + "§7Du hast das §eInventar nach dem Tod behalten §7Perk deaktiviert.");
                    }
                }
            } else {
                p.sendMessage(Main.PREFIX + Main.NOPERMS);
                return;
            }
        }
    }


}
