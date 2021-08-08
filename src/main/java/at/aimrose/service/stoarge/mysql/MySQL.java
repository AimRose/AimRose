package at.aimrose.service.stoarge.mysql;


import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import at.aimrose.service.Main;

public class MySQL {

    public static String username;
    public static String password;
    public static String database;
    public static String host;
    public static String port;
    public static Connection con;

    public static void connect() {


        if (!isConnected()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                Bukkit.getConsoleSender().sendMessage(Main.INSTANCE.PREFIX + "§7MySQL Verbindung aufgebaut.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static void close() {
        if (isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage(Main.INSTANCE.PREFIX + "§7MySQL Verbindung geschlossen.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public static boolean isConnected() {
        return con != null;
    }

    public static void createTable() {
        MySQL.update("CREATE TABLE IF NOT EXISTS `player_perks`\n" +
                "(\n" +
                "    `id`          BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "\n" +
                "    `uuid`        VARCHAR(36)     NOT NULL,\n" +
                "    `perk`        VARCHAR(50)     NOT NULL,\n" +
                "    `active`      BOOLEAN         NOT NULL DEFAULT false,\n" +
                "\n" +
                "    `createdAt`   TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                "    `lastUpdated` TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n" +
                "    PRIMARY KEY (`id`)\n" +
                ");");
    }


    public static void update(String qry) {
        if (isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static ResultSet getResult(String qry) {
        if (isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

