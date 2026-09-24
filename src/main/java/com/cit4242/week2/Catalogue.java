package com.cit4242.week2;

import java.util.List;

/**
 * Catalogue knows nothing about where books come from — it only knows
 * BookSource. That is what makes it testable without a file, and what
 * will let a PostgresBookSource replace CsvBookSource later without
 * touching this class at all.
 */
public class Catalogue {

    private final BookSource source;

    public Catalogue(BookSource source) {
        this.source = source;
    }

    public List<Book> allBooks() {
        return source.load();
    }

    public long countLongBooks() {
        return source.load().stream()
                .filter(Book::isLong)
                .count();
    }
}
