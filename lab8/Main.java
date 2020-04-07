package com.company;

import com.company.controller.AlbumController;
import com.company.controller.ArtistController;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        ArtistController artist = new ArtistController();
        artist.create("Ana", "Romania");
        artist.create("Ana", "Germania");
        artist.create("Mike", "Polonia");
        StringBuilder artistList = artist.findByName("Ana");
        System.out.println(artistList);
        AlbumController album = new AlbumController();
        album.create("Freedom", 1, 2010);
        album.create("NewAlbum", 2, 2008);
        StringBuilder albumList = album.findByArtist(1);
        System.out.println(albumList);
        try {
            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
