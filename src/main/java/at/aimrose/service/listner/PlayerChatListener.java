package at.aimrose.service.listner;

import at.aimrose.service.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();

    String Message = e.getMessage();
        Message.replace("%", "Prozent");


        if (e.getMessage().startsWith("@team")) {
        if (p.hasPermission("aimrose.teamchat")) {
            String msg = e.getMessage();
            for (Player team : Bukkit.getOnlinePlayers()) {
                if (team.hasPermission("aimrose.teamchat")) {
                    e.setCancelled(true);
                    team.sendMessage(main.TeamPREFIX + "§7" + p.getName() + "§8»§7" + msg.replaceAll("@team", "§7"));
                }
            }
        } else {
            e.setCancelled(true);
        }
    }


}

}

