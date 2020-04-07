package com.company.controller;

import com.company.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    private Statement stmt = null;

    public void create(String name, int artistId, int releaseYear) {
        try {
            stmt = Database.getConnection().createStatement();
            String sql = "INSERT INTO albums(name,artist_id,release_year) VALUES('" + name + "','" + artistId + "','" + releaseYear + "')";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder findByArtist(int artistId) {
        String name = null;
        String releaseYear = null;
        String id = null;
        String artist = null;
        StringBuilder result = new StringBuilder();
        try {
            stmt = Database.getConnection().createStatement();
            String sql = "SELECT * FROM albums WHERE artist_id='" + artistId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("name");
                releaseYear = rs.getString("release_year");
                id = rs.getString("id");
                artist = rs.getString("artist_id");
                result.append("Albumul cu id-ul ").append(id).append(" are numele ").append(name).append(" si e lansat in anul ").append(releaseYear).append(". Id artist = ").append(artist).append("\n");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
