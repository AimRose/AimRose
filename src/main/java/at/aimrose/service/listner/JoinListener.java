package at.aimrose.service.listner;

import at.aimrose.service.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPlayedBefore()){
            e.setJoinMessage("§7Willkommen §e" + p.getDisplayName() + "§7auf §d§lAimRose§7!");
        }else{
            e.setJoinMessage("§7[§a+§7] §e" + p.getDisplayName());
        }
        //Wartung

        if(Main.wartung == true) {
            if(!p.hasPermission("aimrose.wartung.join")) {
                p.kickPlayer("§4§lDer Server hat gerade Wartungsarbeiten!");
                return;
            }
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§7[§4-§7] §e" + p.getDisplayName());
    }

    @EventHandler
    public void ServerPing(ServerListPingEvent e) {
        if(Main.wartung == true) {
            e.setMotd(Main.PREFIX + "§4§lAktuell sind Wartungsarbeiten!");
        }

    }
}
