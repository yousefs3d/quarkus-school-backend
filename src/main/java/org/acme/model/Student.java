package org.acme.model;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student extends PanacheEntity {

    private String name;
    private String email;
    private String mobile;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentClassroom> studentClassrooms = new HashSet<>();

}
