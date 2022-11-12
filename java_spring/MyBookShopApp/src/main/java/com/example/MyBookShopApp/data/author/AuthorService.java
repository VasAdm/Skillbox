package com.example.MyBookShopApp.data.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAuthorsData() {
        return authorRepository.findAll();
    }

    public Map<String, List<AuthorEntity>> getAuthorsMap() {
        List<AuthorEntity> authorEntities = getAuthorsData();
        return authorEntities.stream().collect(Collectors.groupingBy((AuthorEntity a) -> a.getName().substring(0,1).toUpperCase(Locale.ROOT)));
    }
}
