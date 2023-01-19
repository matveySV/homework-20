package com.example.nix_spring1.service;

import com.example.nix_spring1.repository.PhotoRepository;
import com.example.nix_spring1.repository.StudentRepository;
import com.example.nix_spring1.repository.entity.PhotoEntity;
import com.example.nix_spring1.repository.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void createStudent(String name, String email) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setEmail(email);
        studentRepository.save(studentEntity);
    }
}
