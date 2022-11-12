package com.example.MyBookShopApp.data.book.book;

import com.example.MyBookShopApp.data.book.file.FileDownloadEntity;
import com.example.MyBookShopApp.data.book.links.Book2AuthorEntity;
import com.example.MyBookShopApp.data.book.links.Book2GenreEntity;
import com.example.MyBookShopApp.data.book.links.Book2UserEntity;
import com.example.MyBookShopApp.data.book.review.BookReviewEntity;
import com.example.MyBookShopApp.data.payments.BalanceTransactionEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@RequiredArgsConstructor
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "SMALLINT NOT NULL DEFAULT 0")
	private int discount;

	@Column(columnDefinition = "VARCHAR(255)")
	private String image;

	@Column(columnDefinition = "SMALLINT NOT NULL")
	private int isBestseller;

	@Column(columnDefinition = "INT NOT NULL")
	private int price;

	@Column(columnDefinition = "DATE NOT NULL")
	private LocalDate pubDate;

	@Column(columnDefinition = "VARCHAR(255) NOT NULL")
	private String slug;

	@Column(columnDefinition = "VARCHAR(255) NOT NULL")
	private String title;

	@OneToMany(mappedBy = "book")
	private List<BookReviewEntity> bookReviews;

	@OneToMany(mappedBy = "book")
	private List<BalanceTransactionEntity> balanceTransactions;

	@OneToMany(mappedBy = "book")
	private List<FileDownloadEntity> fileDownloads;

	@OneToMany(mappedBy = "book")
	private List<Book2UserEntity> books2Users;

	@OneToMany(mappedBy = "book")
	private List<Book2GenreEntity> books2Genres;

	@OneToMany(mappedBy = "book")
	private List<Book2AuthorEntity> books2Authors;
}
