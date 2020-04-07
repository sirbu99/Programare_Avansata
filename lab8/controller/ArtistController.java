package com.company.controller;

import com.company.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    private Statement stmt = null;

    public void create(String name, String country) {
        try {
            stmt = Database.getConnection().createStatement();
            String sql = "INSERT INTO artists(name,country) VALUES('" + name + "','" + country + "')";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder findByName(String name) {
        String tara = null;
        StringBuilder result = new StringBuilder();
        try {
            stmt = Database.getConnection().createStatement();
            String sql = "SELECT * FROM artists WHERE name='" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tara = rs.getString("country");
                result.append("Artistul ").append(name).append(" e din tara ").append(tara).append("\n");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}

