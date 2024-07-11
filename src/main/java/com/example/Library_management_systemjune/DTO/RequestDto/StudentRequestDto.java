package com.example.Library_management_systemjune.DTO.RequestDto;

import com.example.Library_management_systemjune.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequestDto {
    private int age;
    private String name;
    private Department department;
    private String mobNo;


}
