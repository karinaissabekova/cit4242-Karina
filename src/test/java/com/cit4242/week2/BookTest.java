package com.cit4242.week2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void equalRecordsAreEqualAndShareHashCode() {
        Book a = new Book("Clean Code", 464);
        Book b = new Book("Clean Code", 464);

        assertNotSame(a, b);                     // two different objects
        assertEquals(a, b);                       // but equal components
        assertEquals(a.hashCode(), b.hashCode());  // generated together, so they agree
    }

    @Test
    void toStringContainsComponents() {
        Book book = new Book("Clean Code", 464);

        assertTrue(book.toString().contains("464"));
        assertTrue(book.toString().contains("Clean Code"));
    }

    @Test
    void isLongReflectsThePageThreshold() {
        assertTrue(new Book("Big Book", 500).isLong());
        assertFalse(new Book("Short Book", 100).isLong());
    }
}
