package com.example.Library_management_systemjune.controller;

import com.example.Library_management_systemjune.models.Book;
import com.example.Library_management_systemjune.service.AuthorService;
import com.example.Library_management_systemjune.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception{
return bookService.addBook(book);
    }
    @GetMapping("/getAll")
    public List<Book> getAll(){
  return bookService.getAll();
    }
}
