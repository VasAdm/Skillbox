package com.example.MyBookShopApp.data.book.links;

import com.example.MyBookShopApp.data.book.book.BookEntity;
import com.example.MyBookShopApp.data.genre.GenreEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "book2genre")
public class Book2GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private GenreEntity genre;
}
