package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.book.book.BookEntity;
import com.example.MyBookShopApp.data.book.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController
{
	private final BookService bookService;

	public BooksController(BookService bookService)
	{
		this.bookService = bookService;
	}

	@ModelAttribute("booksList")
	public List<BookEntity> booksList(){
		return bookService.getBooksData();
	}

	@GetMapping("/recent")
	public String recentPage()
	{
		return "/books/recent";
	}

	@GetMapping("/popular")
	public String popularPage()
	{
		return "/books/popular";
	}
}
