package com.cit4242.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * A BookSource backed by a CSV file on the classpath (src/main/resources).
 * Expected format per line: title,pages
 */
public class CsvBookSource implements BookSource {

    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        List<Book> books = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(resource)) {
            if (in == null) {
                throw new IllegalStateException("Resource not found: " + resource);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.isBlank()) continue;
                    String[] parts = line.split(",");
                    String title = parts[0].trim();
                    int pages = Integer.parseInt(parts[1].trim());
                    books.add(new Book(title, pages));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + resource, e);
        }

        return books;
    }
}
