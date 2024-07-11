package com.example.Library_management_systemjune.models;

import com.example.Library_management_systemjune.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date issueDate;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    private String validDate;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(cascade = CascadeType.ALL)
    List<Book> bookList=new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();

}
