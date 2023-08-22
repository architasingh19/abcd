package com.example.LibraryManagementSystemSpring.service.impl;


import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.DeleteStudentRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.GetStudentByMobileNumberRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.StudentRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Student.GetStudentResponseDto;
import com.example.LibraryManagementSystemSpring.enums.CardStatus;
import com.example.LibraryManagementSystemSpring.exception.InvalidEmailId;
import com.example.LibraryManagementSystemSpring.exception.InvalidMobileNumber;
import com.example.LibraryManagementSystemSpring.model.Card;
import com.example.LibraryManagementSystemSpring.model.Student;
import com.example.LibraryManagementSystemSpring.repository.StudentRepository;
import com.example.LibraryManagementSystemSpring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setMob(studentRequestDTO.getMob());
        student.setBranch(studentRequestDTO.getBranch());
        student.setEmailId(studentRequestDTO.getEmailId());

        Card card = new Card();
        card.setStatus(CardStatus.ACTIVE);
        card.setValidTill("2026-06-01");
        card.setStudent(student);

        student.setCard(card);

        repository.save(student);
        return "student successfully added🎉";
    }

    @Override
    public String deleteStudentByEmailId(DeleteStudentRequestDto deleteStudentRequestDTO) throws Exception {
        try {
            Student student = repository.findByEmailId(deleteStudentRequestDTO.getEmailId());
            repository.deleteById(student.getStudentId());

            return "Student Deleted Successfully";
        }
        catch (Exception e) {
            throw new InvalidEmailId("please enter the valid email id");

        }
    }

    @Override
    public GetStudentResponseDto getStudentByEmailId(StudentRequestDto studentRequestDTO) throws Exception {
        try {
            Student student = repository.findByEmailId(studentRequestDTO.getEmailId());

            GetStudentResponseDto getStudentResponseDto = new GetStudentResponseDto();
            getStudentResponseDto.setAge(student.getAge());
            getStudentResponseDto.setName(student.getName());
            getStudentResponseDto.setMob(student.getMob());
            getStudentResponseDto.setBranch(student.getBranch());
            getStudentResponseDto.setEmailId(student.getEmailId());
            return getStudentResponseDto;
        }
        catch (Exception e) {
            throw new InvalidEmailId("please enter the valid email id");
        }
    }

    @Override
    public List<GetStudentResponseDto> getAllStudents() {
        List<Student> students = repository.findAll();
        List<GetStudentResponseDto> getStudentResponseDtos = new ArrayList<>();
        for(Student s : students) {

            GetStudentResponseDto getStudentResponseDto = new GetStudentResponseDto();
            getStudentResponseDto.setAge(s.getAge());
            getStudentResponseDto.setName(s.getName());
            getStudentResponseDto.setMob(s.getMob());
            getStudentResponseDto.setBranch(s.getBranch());
            getStudentResponseDto.setEmailId(s.getEmailId());

            getStudentResponseDtos.add(getStudentResponseDto);
        }
        return getStudentResponseDtos;
    }

    @Override
    public GetStudentResponseDto getStudentByMob(GetStudentByMobileNumberRequestDto getStudentByMobileNumberRequestDto) throws Exception {
        try{
            Student student = repository.findByMob(getStudentByMobileNumberRequestDto.getMob());

            GetStudentResponseDto studentDTO = new GetStudentResponseDto();
            studentDTO.setAge(student.getAge());
            studentDTO.setName(student.getName());
            studentDTO.setBranch(student.getBranch());
            studentDTO.setMob(student.getMob());
            studentDTO.setEmailId(student.getEmailId());

            return studentDTO;
        }
        catch (Exception e){
            throw new InvalidMobileNumber("please enter the valid mobile number");
        }
    }

    @Override
    public String deleteStudentByMob(DeleteStudentRequestDto deleteStudentRequestDTO) throws Exception {
        try {
            Student student = repository.findByMob(deleteStudentRequestDTO.getMob());
            repository.deleteById(student.getStudentId());

            return "Student Deleted Successfully";
        }
        catch (Exception e) {
            throw new InvalidMobileNumber("please enter the valid mobile number");

        }
    }
}
