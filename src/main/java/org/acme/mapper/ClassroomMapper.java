package org.acme.mapper;

import org.acme.model.Classroom;
import org.acme.service.dto.ClassroomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClassroomMapper {

    ClassroomMapper INSTANCE = Mappers.getMapper(ClassroomMapper.class);

    List<ClassroomDTO> classroomsToClassroomDTOs(List<Classroom> classrooms);

    ClassroomDTO classroomToClassroomDTO(Classroom classroom);

    void updateClassroom(@MappingTarget Classroom existClassroom, Classroom updatedClassroom);

}
