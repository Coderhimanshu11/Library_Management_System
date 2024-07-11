package com.example.Library_management_systemjune.DTO.ResponseDto;

import lombok.*;
import org.hibernate.annotations.SecondaryRow;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class GetAllStudentsResponseDto {



    private List<StudentDto> students;



    public static class StudentDto {
        private int id;
        private String name;



    }

    }

