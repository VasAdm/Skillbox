package com.example.MyBookShopApp.data.book;

import com.example.MyBookShopApp.data.book.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
//    List<BookEntity> findBooksByAuthor_FirstName(String name);
}
