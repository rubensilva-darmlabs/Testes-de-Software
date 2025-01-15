package com.example;

import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookAttributes() {
        Book book = new Book("Title", "123456", 29.99);
        assertEquals("Title", book.getTitle());
        assertEquals("123456", book.getIsbn());
        assertEquals(29.99, book.getPrice(), 0.01);
    }

    @Test
    public void testBookWithEmptyTitle() {
        Book book = new Book("", "123456", 29.99);
        assertEquals("", book.getTitle());
    }

    @Test
    public void testBookWithNullTitle() {
        Book book = new Book(null, "123456", 29.99);
        assertNull(book.getTitle());
    }

    @Test
    public void testBookWithZeroPrice() {
        Book book = new Book("Free Book", "987654", 0.0);
        assertEquals(0.0, book.getPrice(), 0.01);
    }

    @Test
    public void testBookWithNegativePrice() {
        Book book = new Book("Invalid Book", "654321", -10.0);
        assertEquals(-10.0, book.getPrice(), 0.01);
    }

    @Test
    public void testBookWithLongISBN() {
        Book book = new Book("Book", "12345678901234567890", 10.0);
        assertEquals("12345678901234567890", book.getIsbn());
    }
}
