package com.example.nix_spring1.controllers.dto.mapper;

import com.example.nix_spring1.controllers.dto.StudentDto;
import com.example.nix_spring1.repository.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto toDto(StudentEntity studentEntity);
    StudentEntity toEntity(StudentDto studentDto);
    List<StudentDto> toDtoList(List<StudentEntity> studentEntityList);
    List<StudentEntity> toEntityList(List<StudentDto> studentDtoList);
}
