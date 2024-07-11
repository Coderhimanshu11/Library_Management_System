package com.example.Library_management_systemjune.models;

import com.example.Library_management_systemjune.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionNumber;

    @CreationTimestamp
    private Date transactionDate;
    private boolean isIssueOperation;
    @Enumerated(EnumType.STRING)
private TransactionStatus transactionStatus;



    @ManyToOne
    @JoinColumn
    Card card;

    @ManyToOne
    @JoinColumn
    Book book;
}
