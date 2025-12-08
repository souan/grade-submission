package lu.cnfpc.grade_submission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.cnfpc.grade_submission.model.Grade;
import lu.cnfpc.grade_submission.repository.GradeRepository;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }

    //Methods that interact with gradeRepository

    /*
        Helper Function to find corresponding index.
     */
    private Integer getGradeIndex(String id){
        for (int i = 0; i < gradeRepository.getAll().size(); i++){
            if(gradeRepository.getGrade(i).getId().equals(id)){
                return i;
            }
        }
        //if not found return a number that identifies a not found (eg. negative integer)
        return -1;
    }


    // Get Grade by Id
    public Grade getGradeByID(String id){
        return getGradeIndex(id) == -1 ? new Grade() : gradeRepository.getGrade(getGradeIndex(id));
    }


    public void submitGrade(Grade grade){
        if(getGradeIndex(grade.getId()) == -1){
            gradeRepository.addGrade(grade);
        }else{
            gradeRepository.updateGrade(grade, getGradeIndex(grade.getId()));
        }
    }


    public List<Grade> getAllGrades(){
        return gradeRepository.getAll();
    }

    public void remove(String id){
        gradeRepository.remove(getGradeIndex(id));
    }

    
}
