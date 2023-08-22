package com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student;


import com.example.LibraryManagementSystemSpring.enums.StudentBranch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private int age;
    private String mob;
    private StudentBranch branch;
    private String emailId;
}
