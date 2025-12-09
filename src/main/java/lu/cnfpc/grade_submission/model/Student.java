package lu.cnfpc.grade_submission.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name="students")
public class Student {
    @NotBlank(message= "Firstname cannot be empty!")
    @Column(name="first_name", nullable=false)
    private String firstName;


    @NotBlank(message= "Lastname cannot be empty!")
    @Column(name="last_name", nullable=false)
    private String lastName;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long studentId;

    @OneToMany(mappedBy ="student", cascade = CascadeType.REMOVE, orphanRemoval = true )
    private List<Grade> grades = new ArrayList<>();

    public Student() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    
}
