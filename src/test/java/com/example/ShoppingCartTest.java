package com.example;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void testAddBook() {
        ShoppingCart cart = new ShoppingCart();
        Book book = new Book("O Principice do céu", "1458966-4", 4.99);
        cart.addBook(book);
        assertEquals(1, cart.getBooks().size());
        assertEquals(book, cart.getBooks().get(0));
    }

    @Test
    public void testRemoveBook() {
        ShoppingCart cart = new ShoppingCart();
        Book book = new Book("O Principice do céu", "1458966-4", 4.99);
        cart.addBook(book);
        cart.removeBook(book);
        assertTrue(cart.getBooks().isEmpty());
    }

    @Test
    public void testTotalPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addBook(new Book("Livro 001", "111", 10.00));
        cart.addBook(new Book("Livro 007", "222", 20.00));
        assertEquals(30.00, cart.getTotalPrice(), 0.01);
    }

    @Test
    public void testAddMultipleBooks() {
        ShoppingCart cart = new ShoppingCart();
        cart.addBook(new Book("Livro minha casa minha vida", "111", 15.00));
        cart.addBook(new Book("Livro dolar acima de 6 reais", "222", 25.00));
        cart.addBook(new Book("Livro como esconder dinheiro na cueca", "333", 35.00));
        assertEquals(3, cart.getBooks().size());
    }

    @Test
    public void testRemoveNonexistentBook() {
        ShoppingCart cart = new ShoppingCart();
        Book book = new Book("Livrinho", "111", 10.00);
        cart.removeBook(book);
        assertTrue(cart.getBooks().isEmpty());
    }

    @Test
    public void testTotalPriceAfterRemovingBook() {
        ShoppingCart cart = new ShoppingCart();
        Book book1 = new Book("Livro Esperado", "111", 10.00);
        Book book2 = new Book("Livro Adiado", "222", 20.00);
        cart.addBook(book1);
        cart.addBook(book2);
        cart.removeBook(book1);
        assertEquals(20.00, cart.getTotalPrice(), 0.01);
    }

    @Test
    public void testAddAndRemoveSameBook() {
        ShoppingCart cart = new ShoppingCart();
        Book book = new Book("O Principice do céu", "1458966-4", 4.99);
        cart.addBook(book);
        cart.removeBook(book);
        assertTrue(cart.getBooks().isEmpty());
    }

    @Test
    public void testCartWithNoBooks() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalPrice(), 0.01);
        assertTrue(cart.getBooks().isEmpty());
    }

    @Test
    public void testBooksImmutability() {
        ShoppingCart cart = new ShoppingCart();
        Book book = new Book("O Principice do céu", "1458966-4", 4.99);
        cart.addBook(book);

        List<Book> books = cart.getBooks();

        try {
            books.remove(0); 
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
           
        }

        assertEquals(1, cart.getBooks().size());
    }
}