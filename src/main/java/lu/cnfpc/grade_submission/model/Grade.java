package lu.cnfpc.grade_submission.model;

import java.util.UUID;

public class Grade {
    private String name;
    private String studentId;
    private String subject;
    private String score;
    private String id;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Grade(String name, String subject, String score) {
    //     this.id = UUID.randomUUID().toString();
    //     this.name = name;
    //     this.subject = subject;
    //     this.score = score;
    // }


    // New grade constructor using the html form
    public Grade() {
        this.id = UUID.randomUUID().toString();
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
