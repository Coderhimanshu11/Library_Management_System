package com.example.Library_management_systemjune.controller;

import com.example.Library_management_systemjune.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.UpdateStudentByIdRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.DeleteStudentByIdDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.StudentGetByIdDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_management_systemjune.models.Student;
import com.example.Library_management_systemjune.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }
    @PutMapping("/updatedByMobNo")
    public UpdateStudentMobNoResponseDto updatedByMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws Exception{
return studentService.updatedByMobNo(updateStudentMobRequestDto);
    }

    @DeleteMapping("/deleteById")
    public DeleteStudentByIdDto deleteById(@RequestParam("id")int id) throws Exception {
        return studentService.deleteById(id);
    }
    @PutMapping("/updateById")
    public UpdateStudentByIdRequestDto updateById(@RequestBody UpdateStudentByIdRequestDto updateStudentByIdRequestDto) {
        return studentService.updateById(updateStudentByIdRequestDto);
    }

    @GetMapping("/getById")
    public StudentGetByIdDto getStudentById(@RequestParam("id") int id) {
        return studentService.getStudentById(id);
    }

//    @GetMapping("/getAll")
//    public List<Student> getAll(){
//      return studentService.getAll();
//    }
}
