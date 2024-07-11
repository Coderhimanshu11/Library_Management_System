package com.example.Library_management_systemjune.service;

import com.example.Library_management_systemjune.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_systemjune.models.Author;

public interface AuthorService {
    public String addAuthor(Author author);
    public AuthorResponseDto getByEmail(String email);
}
