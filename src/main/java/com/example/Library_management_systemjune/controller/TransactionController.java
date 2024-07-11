package com.example.Library_management_systemjune.controller;

import com.example.Library_management_systemjune.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.ReturnBookRequestDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.ReturnBookResponseDto;
import com.example.Library_management_systemjune.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
   @Autowired
   TransactionService transactionService;
   @PostMapping("/add")
   public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
return transactionService.issueBook(issueBookRequestDto);
   }
   @PostMapping("/return")
   public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception{
      return transactionService.returnBook(returnBookRequestDto);
   }
}
