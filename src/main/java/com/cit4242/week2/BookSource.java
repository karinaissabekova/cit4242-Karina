package com.cit4242.week2;

import java.util.List;

/**
 * The contract: something that can produce a list of books.
 * Catalogue depends only on this interface, never on a file or a database.
 */
public interface BookSource {
    List<Book> load();
}
