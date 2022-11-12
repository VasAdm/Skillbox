package com.example.MyBookShopApp.data.book.links;

import com.example.MyBookShopApp.data.author.AuthorEntity;
import com.example.MyBookShopApp.data.book.book.BookEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "book2author")
public class Book2AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private AuthorEntity author;

    @Column(columnDefinition = "INT NOT NULL  DEFAULT 0")
    private int sortIndex;

}
