package com.example.Library_management_systemjune.DTO.ResponseDto;

import com.example.Library_management_systemjune.enums.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CardResponseDto {
    private int id;

    private Date issueDate;

    private Date updatedOn;

    private CardStatus cardStatus;

    private String validDate;
}
