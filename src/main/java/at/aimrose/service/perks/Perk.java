package at.aimrose.service.perks;

import java.util.Arrays;
import java.util.List;

public enum Perk {

    /*
       Keep Inventory,
       Glowing,
       Speed,
       No Hunger,
       Strength,
       Haste,
       No Drowning,

     */

    GLOWING("perks.glowing", "§eLeuchten", Arrays.asList("§7Klicke zum aktivieren/deaktivieren.")),
    SPEED("perks.speed", "§eSchnelligkeit", Arrays.asList("§7Klicke zum aktivieren/deaktivieren.")),
    Strength("perks.stärke", "§eStärke", Arrays.asList("§7Klicke zum aktivieren/deaktivieren.")),
    HASTE("perks.haste", "§eSchneller Abbauen", Arrays.asList("§7Klicke zum aktivieren/deaktivieren.")),
    KEEP_XP("perks.keepxp", "§eXP nach dem Tot behalten.", Arrays.asList("§7Klicke zum aktivieren/deaktivieren.")),
    NO_HUNGER("perks.nohunger", "§eKeinen Hunger", Arrays.asList("§7Klicke zum aktivieren/deaktivieren.")),
    KEEP_INVENTORY("perks.keepinventory", "§eInventar nach dem Tot behalten.", Arrays.asList("§7Klicke zum aktivieren/deaktivieren."));

    private String permission;
    private String displayName;
    private List<String> lore;

    Perk(String permission, String displayName, List<String> lore) {
        this.permission = permission;
        this.displayName = displayName;
        this.lore = lore;
    }

    public String getPermission() {
        return permission;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getLore() {
        return lore;
    }
}
