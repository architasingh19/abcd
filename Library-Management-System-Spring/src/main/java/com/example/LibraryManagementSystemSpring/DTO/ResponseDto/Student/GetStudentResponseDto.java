package com.example.LibraryManagementSystemSpring.DTO.ResponseDto.Student;


import com.example.LibraryManagementSystemSpring.enums.StudentBranch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetStudentResponseDto {
    private String name;
    private int age;
    private String mob;
    private StudentBranch branch;
    private String emailId;
}
