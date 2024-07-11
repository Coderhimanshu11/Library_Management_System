package com.example.Library_management_systemjune.DTO.ResponseDto;

import com.example.Library_management_systemjune.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookResponseDto {
    private String transactionNumber;

    private TransactionStatus transactionStatus;
     private String bookName;
}
