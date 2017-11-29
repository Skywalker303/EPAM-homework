package com.company.Entity;

public class Book {
    private final String name;
    private final Author author;

    public Author getAuthor() {
        return author;
    }

    public void setText(String text) {

        this.text = text;
    }

    private String text;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }
}
