package at.aimrose.service.listner;

import at.aimrose.service.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        final String m = e.getMessage().trim();
        float uppercaseLetter = 0;
        for (int i = 0; i < m.length(); i++) {
            if (Character.isUpperCase(m.charAt(i)) && Character.isLetter(m.charAt(i))) {
                uppercaseLetter++;
            }
        }
        if(uppercaseLetter / (float) m.length() > 0.3F) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Main.PREFIX + "§7Bitte schreibe nicht so viel in Caps!");
        }

    }


}
