package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, FileNotFoundException {
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            Object temp = ois.readObject();
            if (!(temp instanceof Catalog)) {
                throw null;
            }
            ois.close();
            return (Catalog) temp;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void view(Document doc) throws URISyntaxException, IOException {
        if (doc.getLocation().startsWith("http")) {
            Desktop.getDesktop().browse(new URI(doc.getLocation()));
        } else {
            Desktop.getDesktop().open(new File(doc.getLocation()));
        }
    }
}
