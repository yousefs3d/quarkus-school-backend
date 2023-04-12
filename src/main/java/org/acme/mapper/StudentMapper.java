package org.acme.mapper;

import org.acme.controller.vm.StudentVM;
import org.acme.model.Classroom;
import org.acme.model.Student;
import org.acme.service.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student studentVMToStudent(StudentVM studentVM);

    List<StudentDTO> studentsToStudentDTOs(List<Student> students);

    StudentDTO studentToStudentDTO(Student student);

    @Mapping(target = "studentClassrooms", ignore = true)
    void updateClassroom(@MappingTarget Student existStudent, Student updatedStudent);

}
