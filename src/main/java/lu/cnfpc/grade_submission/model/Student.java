package lu.cnfpc.grade_submission.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @OneToMany(mappedBy ="student")
    private List<Grade> grades = new ArrayList<>();

    // Many-to-Many relationship with Course
    @ManyToMany
    @JoinTable(
        name = "enrollment",  // Name of the join table
        joinColumns = @JoinColumn(name = "student_id"),  // Foreign key for Student
        inverseJoinColumns = @JoinColumn(name = "course_id")  // Foreign key for Course
    )
    private List<Course> courses = new ArrayList<>();

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

    public List<Grade> getGrades() {
        return this.grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Helper methods to manage the relationship
    public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
    }

    
}
