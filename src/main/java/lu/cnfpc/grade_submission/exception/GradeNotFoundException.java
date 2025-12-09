package lu.cnfpc.grade_submission.exception;

public class GradeNotFoundException extends RuntimeException{
    public GradeNotFoundException(String message){
        super(message);
    }
}
