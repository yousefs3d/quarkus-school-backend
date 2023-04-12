package org.acme.controller;

import org.acme.model.Classroom;
import org.acme.service.ClassroomService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/api/school/class")
public class ClassroomController {

    @Inject
    ClassroomService classroomService;

    @POST
    @Path("add")
    public Response createClassroom(Classroom classroom){
        return Response.ok(classroomService.createClassroom(classroom)).build();
    }

    @GET
    @Path("/all")
    public Response getAllClassrooms(){
        return Response.ok(classroomService.getAllClassrooms()).build();
    }

    @GET
    @Path("/{id}")
    public Response getClassroomById(@PathParam("id") Long id){
        return Response.ok(classroomService.getClassroomById(id)).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateClassroom(@PathParam("id") Long id, Classroom classroom){
        return Response.ok(classroomService.updateClassroom(id, classroom)).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteClassroom(@PathParam("id") Long id){
        return Response.ok(classroomService.deleteClassroom(id)).build();
    }
}
