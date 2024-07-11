package com.example.Library_management_systemjune.models;

import com.example.Library_management_systemjune.enums.BookGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private BookGenre bookGenre;

    private int numberOfPages;
    private int prices;
    private boolean isIssued=true;

    @ManyToOne
    @JoinColumn
    private Author author;

   @ManyToOne
    @JoinColumn
    Card card;

   @OneToMany(cascade = CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();
}
