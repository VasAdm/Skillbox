package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.author.AuthorEntity;
import com.example.MyBookShopApp.data.author.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.service.Response;

import java.util.List;
import java.util.Map;

@Controller
@Api(description = "Authors data")
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String,List<AuthorEntity>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }

    @ApiOperation("Method to get map of Authors")
    @ResponseBody
    @GetMapping("/api/authors")
    public Map<String,List<AuthorEntity>> authors() {
        return authorService.getAuthorsMap();
//        return new ResponseEntity<>(authorService.getAuthorsMap(), HttpStatus.OK);
    }
}
