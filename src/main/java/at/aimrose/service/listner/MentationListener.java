package at.aimrose.service.listner;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MentationListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        String msg = event.getMessage();

        if (p.hasPermission("aimrose.mentation") || (p.hasPermission("aimrose.*"))) {

            String[] words = msg.split(" ");

            for (int i = 0; i < words.length; i++) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    if (online.getName().equalsIgnoreCase(words[i])) {
                        words[i] = "§b@" + online.getName() + "§r";
                    }
                }
            }

            String msgnew = "";

            for (int j = 0; j < words.length; j++) {
                msgnew = msgnew + words[j] + " ";
            }

            event.setMessage(msgnew);
        }

    }


}



