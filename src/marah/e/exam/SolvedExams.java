package marah.e.exam;

import java.util.ArrayList;

public class SolvedExams extends Exams{
    private int result;
    private Exams exam;
    String userName;
    ArrayList<SolvedQuestions> solvedQuestions;


    public SolvedExams(Exams exam, int result, ArrayList<SolvedQuestions> solvedQuestions, String userName){
        this.exam = exam;
        this.result = result;
        this.solvedQuestions = solvedQuestions;
        this.userName = userName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Exams getExam() {
        return exam;
    }

    public ArrayList<SolvedQuestions> getSolvedQuestions() {
        return solvedQuestions;
    }

    public void setSolvedQuestions(ArrayList<SolvedQuestions> solvedQuestions) {
        this.solvedQuestions = solvedQuestions;
    }

    public void setExam(Exams exam) {
        this.exam = exam;
    }

    @Override
    public String getName() {
        return exam.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public double getMarks() {
        return exam.getMarks();
    }

    @Override
    public void setMarks(int marks) {
        super.setMarks(marks);
    }

    @Override
    public int getNumOfQuestions() {
        return super.getNumOfQuestions();
    }

    @Override
    public void setNumOfQuestions(int numOfQuestions) {
        super.setNumOfQuestions(numOfQuestions);
    }

    @Override
    public double getMin_pass_average() {
        return super.getMin_pass_average();
    }

    @Override
    public void setMin_pass_average(int min_pass_average) {
        super.setMin_pass_average(min_pass_average);
    }

    @Override
    public ArrayList<Question> getQuestions() {
        return super.getQuestions();
    }

    @Override
    public void setQuestions(ArrayList<Question> questions) {
        super.setQuestions(questions);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
