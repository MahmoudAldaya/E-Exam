package marah.e.exam;

import java.util.ArrayList;

public class Users {

    private String username;
    private String password;
    private String birthday;
    private String name;
    private String uni_id;
    private int userType; // user type = 0 --> teacher, = 1 --> student, -1 admin
    private String gender;
    private double salary;
    private String specialty;
    ArrayList<SolvedExams> exams = new ArrayList<>();
    int result;

    public Users() {
        this.username = "admin";
        this.password = "admin";
        this.userType = -1;
    }


    public Users(String username, String password, String birthday, String name, String gender, double salary, String specialty) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.name = name;
        this.userType = 0; //teacher
        this.gender = gender;
        this.salary = salary;
        this.specialty = specialty;
    }

    public Users(String username, String password, String birthday, String name, String uni_id, String gender, ArrayList<SolvedExams> exams, int result) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.name = name;
        this.uni_id = uni_id;
        this.userType = 1; //student
        this.gender = gender;
        this.exams = exams;
        this.result = result;
    }


    public String getGender() {
        return gender;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUni_id() {
        return uni_id;
    }

    public void setUni_id(String uni_id) {
        this.uni_id = uni_id;
    }

    public ArrayList<SolvedExams> getExams() {
        return exams;
    }

    public void setExams(ArrayList<SolvedExams> exams) {
        this.exams = exams;
    }


}
