package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity

public class StudentClassroom extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Student_Classroom_Seq")
    @SequenceGenerator(name = "Student_Classroom_Seq", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Student_Id")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Classroom_Id")
    private Classroom classroom;
    private Boolean isActive;
}
