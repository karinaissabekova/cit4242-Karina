package com.cit4242.week2;

import java.util.List;

/**
 * A BookSource that never touches the disk. Used in tests so the test
 * suite stays fast and does not depend on a file being present.
 */
public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("Clean Code", 464, "Robert C. Martin"),
                new Book("Effective Java", 412, "Joshua Bloch"),
                new Book("The Pragmatic Programmer", 352, "David Thomas")
        );
    }
}
