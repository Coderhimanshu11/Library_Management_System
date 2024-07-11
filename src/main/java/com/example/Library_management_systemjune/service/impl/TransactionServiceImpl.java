package com.example.Library_management_systemjune.service.impl;

import com.example.Library_management_systemjune.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.ReturnBookRequestDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.ReturnBookResponseDto;
import com.example.Library_management_systemjune.enums.CardStatus;
import com.example.Library_management_systemjune.enums.TransactionStatus;
import com.example.Library_management_systemjune.models.Book;
import com.example.Library_management_systemjune.models.Card;
import com.example.Library_management_systemjune.models.Transaction;
import com.example.Library_management_systemjune.repository.BookRepository;
import com.example.Library_management_systemjune.repository.CardRepository;
import com.example.Library_management_systemjune.repository.TransactionRepository;
import com.example.Library_management_systemjune.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class TransactionServiceImpl implements TransactionService {
@Autowired
    BookRepository bookRepository;
@Autowired
    CardRepository cardRepository;
@Autowired
    TransactionRepository transactionRepository;
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
        Transaction transaction=new Transaction();
transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
transaction.setIssueOperation(true);
        Card card;
        try{
            card=cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid cardId !!!");
        }
        transaction.setCard(card);

        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();

        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("invalid bookId !!!");
        }
        transaction.setBook(book);
if(card.getCardStatus()!= CardStatus.ACTIVATED){
    transaction.setTransactionStatus(TransactionStatus.FAILED);
    transactionRepository.save(transaction);
    throw new Exception("Card is not Activated");
}
if (book.isIssued()==true){
    transaction.setTransactionStatus(TransactionStatus.FAILED);
    transactionRepository.save(transaction);
    throw new Exception("book is not available");

}
transaction.setTransactionStatus(TransactionStatus.SUCCESS);
   book.setIssued(true);
   book.setCard(card);
   book.getTransactionList().add(transaction);

   card.getBookList().add(book);
   card.getTransactionList().add(transaction);
   cardRepository.save(card);
   IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
   issueBookResponseDto.setBookName(book.getTitle());
   issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
   issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
   return issueBookResponseDto;
    }
    @Override
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(false);

        Card card;
        try {
            card = cardRepository.findById(returnBookRequestDto.getCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid cardId !!!");
        }
        transaction.setCard(card);

        Book book;
        try {
            book = bookRepository.findById(returnBookRequestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid bookId !!!");
        }
        transaction.setBook(book);

        if (!book.isIssued() || !book.getCard().equals(card)) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not issued to this card");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(false);
        book.setCard(null);
        book.getTransactionList().add(transaction);

        card.getBookList().remove(book);
        card.getTransactionList().add(transaction);
        cardRepository.save(card);

        ReturnBookResponseDto returnBookResponseDto = new ReturnBookResponseDto();
        returnBookResponseDto.setBookName(book.getTitle());
        returnBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        returnBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());
        return returnBookResponseDto;
    }
}
