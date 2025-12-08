package lu.cnfpc.grade_submission.model;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Student {
    @NotBlank(message= "Firstname cannot be empty!")
    private String firstName;
    @NotBlank(message= "Lastname cannot be empty!")
    private String lastName;
    private String studentId;

    public Student() {
        studentId = UUID.randomUUID().toString();
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

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
}
