package com.example.Library_management_systemjune.service;

import com.example.Library_management_systemjune.models.Book;

import java.util.List;

public interface BookService {
    public String addBook(Book book) throws Exception;
    public List<Book> getAll();
}
