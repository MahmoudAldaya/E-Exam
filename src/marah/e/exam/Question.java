package marah.e.exam;

public class Question {
    private String id;
    private String q_text;
    private double marks;
    private String type;
    private String answer;
    private String choice1;
    private String choice2;
    private String choice3;

    public Question(String id, String q_text, double marks, String type, String answer) { // this constructor for TF, FB
        this.id = id;
        this.q_text = q_text;
        this.marks = marks;
        this.type = type;
        this.answer = answer;
    }

    public Question(String id, String q_text, double marks, String type, String answer, String choice1, String choice2, String choice3) {
        this.id = id;
        this.q_text = q_text;
        this.marks = marks;
        this.type = type;
        this.answer = answer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }

    public Question() {
    }

    public String getType() {
        return type;
    }

    public String getAnswer() {
        return answer;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQ_text() {
        return q_text;
    }

    public void setQ_text(String q_text) {
        this.q_text = q_text;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

}
