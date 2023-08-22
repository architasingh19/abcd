package com.example.LibraryManagementSystemSpring.service;


import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.DeleteStudentRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.GetStudentByMobileNumberRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student.StudentRequestDto;
import com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Student.GetStudentResponseDto;

import java.util.List;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDTO);
    public String deleteStudentByEmailId(DeleteStudentRequestDto deleteStudentRequestDTO) throws Exception;
    public GetStudentResponseDto getStudentByEmailId(StudentRequestDto studentRequestDTO) throws Exception;
    public List<GetStudentResponseDto> getAllStudents();
    public GetStudentResponseDto getStudentByMob(GetStudentByMobileNumberRequestDto getStudentByMobileNumberRequestDto) throws Exception;
    public String deleteStudentByMob(DeleteStudentRequestDto deleteStudentDTO) throws Exception;

}
