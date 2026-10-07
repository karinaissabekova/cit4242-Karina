package com.cit4242.week2;

import java.util.List;

/**
 * Catalogue knows nothing about where books come from — it only knows
 * BookSource. That is what makes it testable without a file.
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

    /**
     * Returns the titles of every book by the given author in sorted order.
     * An unknown author naturally produces an empty list.
     */
    public List<String> titlesBy(String author) {
        return source.load().stream()
                .filter(book -> book.author().equals(author))
                .map(Book::title)
                .sorted()
                .toList();
    }
}
