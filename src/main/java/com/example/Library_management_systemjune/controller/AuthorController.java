package com.example.Library_management_systemjune.controller;

import com.example.Library_management_systemjune.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_systemjune.models.Author;
import com.example.Library_management_systemjune.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
    return authorService.addAuthor(author);
    }
    @GetMapping("/get-by-email")
    public AuthorResponseDto getByEmail(@RequestParam("email") String email){
        return authorService.getByEmail(email);
    }
}
