package lu.cnfpc.grade_submission.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lu.cnfpc.grade_submission.model.Grade;

@Repository
public class GradeRepository {
 
    //ArrayList of grade POJO objects, will be replaced by Database later
    private List<Grade> studentGrades = new ArrayList<>();


    //CRUD operations will be implemented here

    //get a grade by index
    public Grade getGrade(int index){
        return studentGrades.get(index);
    }

    //get all grades
    public List<Grade> getAll(){
        return studentGrades;
    }

    //add a grade
    public void addGrade(Grade grade){
        studentGrades.add(grade);
    }

    //update a grade
    public void updateGrade(Grade grade, int index){
        studentGrades.set(index, grade);
    }

    //remove a grade
    public void remove(int index){
        studentGrades.remove(index);
    }
}
