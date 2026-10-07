package com.cit4242.week2;

/**
 * Book is a record: title, pages and author are immutable bookkeeping data.
 * isLong() remains a method because it contains a business decision.
 */
public record Book(String title, int pages, String author) {

    /**
     * Backwards-compatible constructor used by the Week 2 code.
     */
    public Book(String title, int pages) {
        this(title, pages, "Unknown");
    }

    public boolean isLong() {
        return pages > 400;
    }
}
