package com.example.Library_management_systemjune.service.impl;

import com.example.Library_management_systemjune.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_systemjune.models.Author;
import com.example.Library_management_systemjune.models.Book;
import com.example.Library_management_systemjune.repository.AuthorRepository;
import com.example.Library_management_systemjune.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "author added successfully";

        }

    @Override
    public AuthorResponseDto getByEmail(String email) {
       Author author= authorRepository.findByEmail(email);
       AuthorResponseDto authorResponseDto=new AuthorResponseDto();
       authorResponseDto.setAge(author.getAge());
       authorResponseDto.setName(author.getName());
       return authorResponseDto;

    }
}

