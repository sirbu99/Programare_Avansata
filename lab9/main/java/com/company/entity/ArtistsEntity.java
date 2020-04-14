package com.company.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "artists", schema = "public", catalog = "MusicAlbums")
public class ArtistsEntity {
    private int id;
    private String name;
    private String country;
    private Collection<AlbumsEntity> albumsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 100)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistsEntity that = (ArtistsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @OneToMany(mappedBy = "artistsByArtistId")
    public Collection<AlbumsEntity> getAlbumsById() {
        return albumsById;
    }

    public void setAlbumsById(Collection<AlbumsEntity> albumsById) {
        this.albumsById = albumsById;
    }
}
