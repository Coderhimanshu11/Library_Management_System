package com.example.Library_management_systemjune.service;

import com.example.Library_management_systemjune.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.UpdateStudentByIdRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.DeleteStudentByIdDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.GetAllStudentsResponseDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.StudentGetByIdDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_management_systemjune.models.Student;

import java.util.List;

public interface StudentService {
   // public String addStudent(Student student);

    String addStudent(StudentRequestDto studentRequestDto);

    public DeleteStudentByIdDto deleteById(int id) throws Exception;
    public UpdateStudentByIdRequestDto updateById(UpdateStudentByIdRequestDto updateStudentByIdRequestDto);
   public StudentGetByIdDto getStudentById(int id);
   // public GetAllStudentsResponseDto getAll();
    public UpdateStudentMobNoResponseDto updatedByMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws Exception;
}
