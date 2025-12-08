package lu.cnfpc.grade_submission.model;

import java.util.UUID;

public class Student {
    private String studentId;
    private String firstName;
    private String LastName;


    public Student(String firstName, String LastName) {
        this.studentId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.LastName = LastName;
    }


    public Student() {
        this.studentId = UUID.randomUUID().toString();
    }


    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }


    
}
