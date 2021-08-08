package at.aimrose.service.perks;

import at.aimrose.service.stoarge.mysql.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class PerkManager {

    public static void updatePlayerPerkState(UUID uuid, Perk perk, boolean active) {
        ResultSet resultSet = MySQL.getResult("SELECT * FROM player_perks WHERE uuid = '" + uuid + "' AND perk = '" + perk.name() + "';");
        try {
            if (resultSet.next()) {
                MySQL.update("UPDATE `player_perks` SET active = " + (active ? 1 : 0) + " WHERE uuid = '" + uuid + "' AND perk = '" + perk.name() + "';");
            } else {
                MySQL.update("INSERT INTO `player_perks` (`uuid`, `perk`, `active`) VALUES ('"+ uuid +"', '" + perk.name() +"', " + (active ? 1 : 0) + ");");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Perk> getPlayerPerkStates(UUID uuid) {
        ResultSet resultSet = MySQL.getResult("SELECT * FROM player_perks WHERE uuid = '" + uuid + "';");
        List<Perk> activePerks = new ArrayList<>();

        try {
            while(resultSet.next()) {
                Perk perk = Perk.valueOf(resultSet.getString("perk"));
                boolean active = resultSet.getBoolean("active");

                if (active)
                    activePerks.add(perk);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return activePerks;
    }

}
