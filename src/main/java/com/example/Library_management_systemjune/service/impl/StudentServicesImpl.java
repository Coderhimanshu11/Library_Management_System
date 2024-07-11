package com.example.Library_management_systemjune.service.impl;

import com.example.Library_management_systemjune.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.UpdateStudentByIdRequestDto;
import com.example.Library_management_systemjune.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library_management_systemjune.DTO.ResponseDto.*;
import com.example.Library_management_systemjune.Exception.StudentNotFoundException;
import com.example.Library_management_systemjune.enums.CardStatus;
import com.example.Library_management_systemjune.models.Card;
import com.example.Library_management_systemjune.models.Student;
import com.example.Library_management_systemjune.repository.StudentRepository;
import com.example.Library_management_systemjune.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServicesImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


//    @Override
//    public String addStudent(Student student) {
//        return null;
//    }

    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidDate("2024-02-01");
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);
        return "Student added successfully";
    }

    @Override
    public DeleteStudentByIdDto deleteById(int id) throws Exception {
        DeleteStudentByIdDto deleteStudentByIdDto = new DeleteStudentByIdDto();


        Optional<Student> optionalStudent = studentRepository.findById(id);


        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();


            deleteStudentByIdDto.setId(student.getId());


            studentRepository.deleteById(id);

        } else {

            throw new EntityNotFoundException("Student with ID " + id + " not found.");
        }

        return deleteStudentByIdDto;
    }


    @Override
    public UpdateStudentByIdRequestDto updateById(UpdateStudentByIdRequestDto updateStudentByIdRequestDto) {
        int id = updateStudentByIdRequestDto.getId();
        String name = updateStudentByIdRequestDto.getName();
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(name);
            studentRepository.save(student);
            updateStudentByIdRequestDto.setId(student.getId());
            updateStudentByIdRequestDto.setName(student.getName());
            return updateStudentByIdRequestDto; // Return updated DTO
        } else {
            return null;
        }
    }

    @Override
    public StudentGetByIdDto getStudentById(int id) {
        Student student=studentRepository.findById(id).get();
StudentGetByIdDto studentGetByIdDto=new StudentGetByIdDto();
studentGetByIdDto.setId(student.getId());
studentGetByIdDto.setName(student.getName());
studentGetByIdDto.setDepartment(student.getDepartment());
studentGetByIdDto.setAge(student.getAge());
studentGetByIdDto.setMobNo(student.getMobNo());
        CardResponseDto cardResponseDto=new CardResponseDto();
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setUpdatedOn(student.getCard().getUpdatedOn());
        cardResponseDto.setValidDate(student.getCard().getValidDate());
        cardResponseDto.setId(student.getCard().getId());

        studentGetByIdDto.setCardResponseDto(cardResponseDto);
        return studentGetByIdDto;
    }

        // getStudent(int id) {
//        Optional<Student> optionalStudent = studentRepository.findById(id);
//        if (optionalStudent.isPresent()) {
//            Student student = optionalStudent.get();
//            return student.toString();
//        } else {
//            return "Student with ID " + id + " not found";
//        }
//    }

//    @Override
//    public GetAllStudentsResponseDto getAll() {
//        List<Student> students = studentRepository.findAll();
//        GetAllStudentsResponseDto response = new GetAllStudentsResponseDto();
//        List<GetAllStudentsResponseDto.StudentDto> studentDtos = students.stream()
//                .map(student -> {
//                    GetAllStudentsResponseDto.StudentDto dto = new GetAllStudentsResponseDto.StudentDto();
//                    dto.setId(student.getId());
//                    dto.setName(student.getName());
//                    dto.setEmail(student.getEmail());
//                    return dto;
//                })
//                .collect(Collectors.toList());
//        response.setStudents(studentDtos);
//        return response;
//    }

        @Override
        public UpdateStudentMobNoResponseDto updatedByMobNo (UpdateStudentMobRequestDto updateStudentMobRequestDto) throws
        Exception {
            try {
                Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();
                student.setMobNo(updateStudentMobRequestDto.getMobNo());
                Student updatedStudent = studentRepository.save(student);
                UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
                updateStudentMobNoResponseDto.setName(updatedStudent.getName());
                updateStudentMobNoResponseDto.setMobNo(updatedStudent.getMobNo());
                return updateStudentMobNoResponseDto;
            } catch (Exception e) {
                throw new StudentNotFoundException("Invalid student Id");

            }

        }


    }

