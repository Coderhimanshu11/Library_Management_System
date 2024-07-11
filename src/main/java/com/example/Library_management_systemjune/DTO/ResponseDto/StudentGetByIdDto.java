package com.example.Library_management_systemjune.DTO.ResponseDto;

import com.example.Library_management_systemjune.enums.Department;
import com.example.Library_management_systemjune.models.Card;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentGetByIdDto {
    private int id;
    private String name;
    private int age;


    private Department department;

    private String mobNo;

    CardResponseDto cardResponseDto;
}
