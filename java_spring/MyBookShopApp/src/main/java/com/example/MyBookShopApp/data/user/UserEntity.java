package com.example.MyBookShopApp.data.user;

import com.example.MyBookShopApp.data.book.book.BookEntity;
import com.example.MyBookShopApp.data.book.file.FileDownloadEntity;
import com.example.MyBookShopApp.data.book.links.Book2UserEntity;
import com.example.MyBookShopApp.data.book.review.BookReviewEntity;
import com.example.MyBookShopApp.data.book.review.BookReviewLikeEntity;
import com.example.MyBookShopApp.data.book.review.MessageEntity;
import com.example.MyBookShopApp.data.payments.BalanceTransactionEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String hash;

    @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime regTime;

    @Column(columnDefinition = "INT NOT NULL")
    private int balance;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<BookReviewEntity> bookReviews;

    @OneToMany(mappedBy = "user")
    private List<BalanceTransactionEntity> balanceTransactions;

    @OneToMany(mappedBy = "user")
    private List<FileDownloadEntity> fileDownloads;

    @OneToMany(mappedBy = "user")
    private List<MessageEntity> messages;

    @OneToMany(mappedBy = "user")
    private List<UserContactEntity> userContacts;

    @OneToMany(mappedBy = "user")
    private List<BookReviewLikeEntity> bookReviewLikes;

    @OneToMany(mappedBy = "user")
    private List<Book2UserEntity> books2Users;
}
