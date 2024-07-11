package com.example.Library_management_systemjune.service.impl;

import com.example.Library_management_systemjune.models.Author;
import com.example.Library_management_systemjune.models.Book;
import com.example.Library_management_systemjune.repository.AuthorRepository;
import com.example.Library_management_systemjune.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
@Autowired
    AuthorRepository authorRepository;

    @Override
    public String addBook(Book book) throws Exception {
        Author author = null;
        try{
            author=authorRepository.findById(book.getAuthor().getId()).get();
        }catch (Exception e){
            System.out.println("Author is not present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
        return "Book added";

    }

    @Override
    public List<Book> getAll() {
        return authorRepository.findAll().stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toList());
    }
}
