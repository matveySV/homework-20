package com.example.nix_spring1.controllers;

import com.example.nix_spring1.controllers.dto.StudentDto;
import com.example.nix_spring1.controllers.dto.mapper.StudentMapper;
import com.example.nix_spring1.repository.entity.StudentEntity;
import com.example.nix_spring1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
    StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(studentDto);
    StudentDto responseDto = StudentMapper.INSTANCE.toDto(
            studentService.createStudent(studentEntity));

    return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto){
        StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(studentDto);
        StudentDto responseDto = StudentMapper.INSTANCE.toDto(studentService.updateStudent(studentEntity));
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {
        StudentDto responseDto = StudentMapper.INSTANCE.toDto(studentService.getStudent(studentId));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getStudents() {
        List<StudentDto> responseDto = StudentMapper.INSTANCE.toDtoList(
                studentService.getStudents());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
