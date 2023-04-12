package org.acme.controller;


import org.acme.controller.vm.StudentVM;
import org.acme.model.Student;
import org.acme.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api/school/student")
public class StudentController {

    @Inject
    StudentService studentService;

    @POST
    @Path("/add")
    public Response addStudent(StudentVM studentVM){
        return Response.ok(studentService.createStudent(studentVM)).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") Long id){
        return Response.ok(studentService.getStudentById(id)).build();
    }

    @GET
    @Path("/all")
    public Response getAllStudents(){
        return Response.ok(studentService.getAllStudents()).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateStudent(@PathParam("id") Long id, Student student){
        return Response.ok(studentService.updateStudent(id, student)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudent(@PathParam("id") Long id){
        return Response.ok(studentService.deleteStudent(id)).build();
    }
}
