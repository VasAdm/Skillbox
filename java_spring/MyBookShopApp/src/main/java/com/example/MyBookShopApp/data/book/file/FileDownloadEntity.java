package com.example.MyBookShopApp.data.book.file;

import com.example.MyBookShopApp.data.book.book.BookEntity;
import com.example.MyBookShopApp.data.user.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "file_download")
public class FileDownloadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private BookEntity book;

    @Column(columnDefinition = "INT NOT NULL DEFAULT 1")
    private int count;

}
