package org.acme.service;


import org.acme.controller.vm.StudentVM;
import org.acme.mapper.ClassroomMapper;
import org.acme.mapper.StudentMapper;
import org.acme.model.Classroom;
import org.acme.model.Student;
import org.acme.model.StudentClassroom;
import org.acme.service.dto.ClassroomDTO;
import org.acme.service.dto.StudentDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@ApplicationScoped
public class StudentService {

    @Inject
    StudentMapper studentMapper;

    @Inject
    ClassroomMapper classroomMapper;

    private void persistStudent(Student student){
        Student.persist(student);
    }

    private void setStudentClassroom(Student student, List<Long> classroomIds){
        List<Classroom> classrooms = Classroom.list("id",classroomIds);
        if(!classrooms.isEmpty()){
            List<StudentClassroom> studentClassrooms = classrooms.stream().map(classroom -> {
                StudentClassroom studentClassroom = new StudentClassroom();
                studentClassroom.setClassroom(classroom);
                studentClassroom.setStudent(student);
                studentClassroom.setIsActive(true);
                return studentClassroom;
            }).collect(Collectors.toList());
            StudentClassroom.persist(studentClassrooms);
        }
    }
    public StudentDTO createStudent(StudentVM studentVM){
        Student student = studentMapper.studentVMToStudent(studentVM);
        this.persistStudent(student);
        this.setStudentClassroom(student,studentVM.getClassroomIds());
        return studentMapper.studentToStudentDTO(student);
    }

    public StudentDTO getStudentById(Long id){
        return studentMapper.studentToStudentDTO(Student.findById(id));
    }

    public List<StudentDTO> getAllStudents(){
        return studentMapper.studentsToStudentDTOs(Student.findAll().list());
    }

    public StudentDTO updateStudent(Long id, Student updatedStudent){
        Student existStudent = Student.findById(id);
        if(existStudent == null){
            throw new RuntimeException("Error");
        }
        studentMapper.updateClassroom(existStudent, updatedStudent);
        this.persistStudent(existStudent);
        return studentMapper.studentToStudentDTO(existStudent);
    }

    public Boolean deleteStudent(Long id){
        return Student.deleteById(id);
    }

    public List<ClassroomDTO> getAllClassroomsByStudentId(Long id){
        List<StudentClassroom> studentClassrooms = StudentClassroom.find("student.id", id).list();
        return studentClassrooms.stream().map(studentClassroom -> {
            return classroomMapper.classroomToClassroomDTO(studentClassroom.getClassroom());
        }).collect(Collectors.toList());
    }
}
