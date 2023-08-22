package com.example.LibraryManagementSystemSpring.controller;


import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.DeleteStudentRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.GetStudentByMobileNumberRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.StudentRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Student.GetStudentResponseDto;
import com.example.LibraryManagementSystemSpring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDTO) {
        return service.addStudent(studentRequestDTO);
    }
     @GetMapping("/get-by-emailId")
     public GetStudentResponseDto getByEmailId(@RequestBody StudentRequestDto studentRequestDTO) throws Exception {
         return service.getStudentByEmailId(studentRequestDTO);
     }
    @GetMapping("/get-all")
    public List<GetStudentResponseDto> getAllStudenList() {
        return service.getAllStudents();
    }
    @GetMapping("/get-by-mob")
    public GetStudentResponseDto getByMob(@RequestBody GetStudentByMobileNumberRequestDto getStudentByMobileNumberRequestDto) throws Exception {
        return service.getStudentByMob(getStudentByMobileNumberRequestDto);
    }
     @DeleteMapping("/delete-by-email")
     public String deleteStudentByEmail(@RequestBody DeleteStudentRequestDto deleteStudentDTO) throws Exception{
         return service.deleteStudentByEmailId(deleteStudentDTO);
     }
    @DeleteMapping("/delete-by-mob")
    public String deleteStudent(@RequestBody DeleteStudentRequestDto deleteStudentRequestDTO) throws Exception {
        return service.deleteStudentByMob(deleteStudentRequestDTO);
    }
}
