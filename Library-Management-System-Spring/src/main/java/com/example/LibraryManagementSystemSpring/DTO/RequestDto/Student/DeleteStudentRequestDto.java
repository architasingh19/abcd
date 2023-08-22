package com.example.LibraryManagementSystemSpring.DTO.RequestDto.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeleteStudentRequestDto {
    private String mob;
    private String emailId;
}
