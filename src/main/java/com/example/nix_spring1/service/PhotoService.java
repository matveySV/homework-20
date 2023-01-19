package com.example.nix_spring1.service;

import com.example.nix_spring1.repository.PhotoRepository;
import com.example.nix_spring1.repository.StudentRepository;
import com.example.nix_spring1.repository.entity.PhotoEntity;
import com.example.nix_spring1.repository.entity.StudentEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {
    private final PhotoRepository photoRepository;
    private final StudentRepository studentRepository;

    public void addPhotoToStudent(String url, String description, long studentId) {
//        StudentEntity studentEntity = studentRepository.findById(studentId)
//                .orElseThrow(() -> new RuntimeException("Student not found"));

        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setUrl(url);
        photoEntity.setDescripion(description);
        photoEntity.setStudent((studentRepository.findById(studentId)).get());
        photoRepository.save(photoEntity);
    }

    public List<PhotoEntity> getPhotoByDescription(String description){
        return photoRepository.findPhotoEntitiesByDescripion(description);
    }
}
