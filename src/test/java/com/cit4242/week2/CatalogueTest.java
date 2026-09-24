package com.cit4242.week2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogueTest {

    // THIS is the test the assignment cares about most: it never touches
    // the disk. It uses InMemoryBookSource instead of CsvBookSource.
    @Test
    void loadsBooksFromMemory_withoutTouchingDisk() {
        Catalogue catalogue = new Catalogue(new InMemoryBookSource());

        List<Book> books = catalogue.allBooks();

        assertEquals(3, books.size());
        assertTrue(books.contains(new Book("Clean Code", 464)));
    }

    @Test
    void countsLongBooksCorrectly() {
        Catalogue catalogue = new Catalogue(new InMemoryBookSource());

        assertEquals(2, catalogue.countLongBooks()); // Clean Code (464) and Effective Java (412)
    }

    // A second test shows the CSV implementation also satisfies the
    // same contract — proving BookSource is a real abstraction, not
    // just a wrapper around one class.
    @Test
    void loadsBooksFromCsvFile() {
        Catalogue catalogue = new Catalogue(new CsvBookSource("books.csv"));

        List<Book> books = catalogue.allBooks();

        assertFalse(books.isEmpty());
        assertEquals(3, books.size());
    }
}
