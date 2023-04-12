package org.acme.controller.vm;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentVM {

    private Long id;
    private String name;
    private String email;
    private String mobile;
    private List<Long> classroomIds;
}
