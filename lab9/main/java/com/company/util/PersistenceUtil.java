package com.company.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil instance = null;
    private EntityManagerFactory factory;


    private PersistenceUtil() {
        factory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public void closeFactory(){
        factory.close();
    }

    public EntityManagerFactory getFactory(){
        return factory;
    }

    public static PersistenceUtil getInstance() {
        if (instance == null) {
            instance = new PersistenceUtil();
        }
        return instance;
    }
}
