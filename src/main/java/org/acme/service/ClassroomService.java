package org.acme.service;

import org.acme.mapper.ClassroomMapper;
import org.acme.model.Classroom;
import org.acme.service.dto.ClassroomDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Transactional
@ApplicationScoped
public class ClassroomService {

    @Inject
    ClassroomMapper classroomMapper;

    private void persistClassroom(Classroom classroom){
        Classroom.persist(classroom);
    }

    public ClassroomDTO createClassroom(Classroom classroom){
        this.persistClassroom(classroom);
        return classroomMapper.classroomToClassroomDTO(classroom);
    }

    public List<ClassroomDTO> getAllClassrooms(){
        return classroomMapper.classroomsToClassroomDTOs(Classroom.findAll().list());
    }

    public ClassroomDTO getClassroomById(Long id){
        return classroomMapper.classroomToClassroomDTO(Classroom.findById(id));
    }

    public ClassroomDTO updateClassroom(Long id, Classroom updatedClassroom){
        Classroom existClassroom = Classroom.findById(id);
        if(existClassroom == null){
            throw new RuntimeException("Error");
        }
        classroomMapper.updateClassroom(existClassroom, updatedClassroom);
        persistClassroom(existClassroom);
        return classroomMapper.classroomToClassroomDTO(existClassroom);
    }

    public Boolean deleteClassroom(Long id){
        return Classroom.deleteById(id);
    }
}
