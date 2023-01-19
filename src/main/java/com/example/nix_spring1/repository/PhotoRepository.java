package com.example.nix_spring1.repository;

import com.example.nix_spring1.repository.entity.PhotoEntity;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
    List<PhotoEntity> findPhotoEntitiesByDescripion(String description);
    //findPhotoByDescription(String description);
}
