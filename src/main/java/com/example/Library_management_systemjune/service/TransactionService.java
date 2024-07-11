package com.example.Library_management_systemjune.service;

import com.example.Library_management_systemjune.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.ReturnBookRequestDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.ReturnBookResponseDto;
import com.example.Library_management_systemjune.controller.TransactionController;
import org.springframework.stereotype.Service;


public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;

    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception;
}
