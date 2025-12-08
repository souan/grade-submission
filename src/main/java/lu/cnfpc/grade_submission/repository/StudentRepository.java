package lu.cnfpc.grade_submission.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import lu.cnfpc.grade_submission.model.Student;

@Repository
public class StudentRepository {
    //Student datastore
    private ArrayList<Student> students = new ArrayList<>();

    //CRUD Operations that are on the Data Layer

    //get all students
    public ArrayList<Student> getStudents(){
        return students;
    }

    //get student by index
    public Student getStudent(int index){
        return students.get(index);
    }

    //add new student
    public void addStudent(Student student){
        students.add(student);
    }

    //Update existing student
    public void updateStudent(Student student, int index){
        students.get(index).setFirstName(student.getFirstName());
        students.get(index).setLastName(student.getLastName());
    }

    //Remove student
    public void removeStudent(Student student){
        students.remove(student);
    }
}
