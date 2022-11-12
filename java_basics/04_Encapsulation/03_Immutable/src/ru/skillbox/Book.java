package ru.skillbox;

public class Book {
    private final String name;
    private final String author;
    private final int numberOfPages;
    private final int isbn;

    public Book(String name, String author, int numberOfPages, int isbn) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getIsbn() {
        return isbn;
    }
}
