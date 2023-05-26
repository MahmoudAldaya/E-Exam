package marah.e.exam;

import java.util.ArrayList;


public class Exams {

    private String name;
    private String id;
    private int marks;
    private int numOfQuestions;
    private int min_pass_average;
    private ArrayList <Question> questions;
    private String questionsType;


    public Exams(String name, String id, int marks, int numOfQuestions, int min_pass_average, ArrayList<Question> questions, String questionsType) {
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.numOfQuestions = numOfQuestions;
        this.min_pass_average = min_pass_average;
        this.questions = questions;
        this.questionsType = questionsType;
    }

    public Exams() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getQuestionsType() {
        return questionsType;
    }

    public void setQuestionsType(String questionsType) {
        this.questionsType = questionsType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public double getMin_pass_average() {
        return min_pass_average;
    }

    public void setMin_pass_average(int min_pass_average) {
        this.min_pass_average = min_pass_average;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }


}
