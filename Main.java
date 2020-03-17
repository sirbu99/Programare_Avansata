package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Java Resources", "d://java//catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro//~acf//java//slides//en//intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IOException, InvalidCatalogException, URISyntaxException {
        Catalog catalog= CatalogUtil.load("d://java//catalog.ser");
        assert catalog != null;
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}
