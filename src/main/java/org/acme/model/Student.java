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

public class Student extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Student_Seq")
    @SequenceGenerator(name = "Student_Seq", allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private String mobile;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentClassroom> studentClassrooms = new HashSet<>();

}
