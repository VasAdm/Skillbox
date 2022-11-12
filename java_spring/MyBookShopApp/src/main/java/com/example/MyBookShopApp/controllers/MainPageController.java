package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.book.book.BookEntity;
import com.example.MyBookShopApp.data.book.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<BookEntity> recommendedBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/")
    @ApiParam(name = "Main")
    public String mainPage(){
        return "index";
    }

}