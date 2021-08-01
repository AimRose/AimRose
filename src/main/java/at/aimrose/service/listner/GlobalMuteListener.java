package at.aimrose.service.listner;

import at.aimrose.service.commands.Globalmute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import at.aimrose.service.main;

public class GlobalMuteListener implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if(Globalmute.globalmute){
            if(e.getPlayer().hasPermission("system.globalmute.bypass")){
                return;
            }
            e.getPlayer().sendMessage(main.PREFIX + "§7Zurzeit ist der Chat leider §4deaktiviert§7.");
            e.setCancelled(true);
        }
    }

}
