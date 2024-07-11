package com.example.Library_management_systemjune.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnBookRequestDto {
    private int cardId;
    private int bookId;
}
