package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Classroom extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Classroom_Seq")
    @SequenceGenerator(name = "Classroom_Seq", allocationSize = 1)
    private Long id;
    private String room;
    private String subject;
    private String building;
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentClassroom> studentClassrooms = new HashSet<>();

}
