package org.acme.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassroomDTO {
    private Long id;
    private String room;
    private String subject;
    private String building;
}
