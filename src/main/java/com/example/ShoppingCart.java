package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class ShoppingCart {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    // Retorna uma cópia imutável da lista
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public double getTotalPrice() {
        return books.stream().mapToDouble(Book::getPrice).sum();
    }
}
