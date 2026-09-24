package com.cit4242.week2;

/**
 * Book is a record: title and pages are pure bookkeeping,
 * equals/hashCode/toString are generated and agree with each other.
 *
 * isLong() is KEPT as a method (not deleted with the getters) because
 * it contains a decision — the choice of 400 pages as the threshold
 * for "long" is a judgement call, not bookkeeping. Records remove
 * bookkeeping, never decisions.
 */
public record Book(String title, int pages) {

    public boolean isLong() {
        return pages > 400;
    }
}
