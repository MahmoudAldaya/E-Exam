package marah.e.exam;

public class SolvedQuestions extends Question{
    String studentAnswer;
    Question question;



    public SolvedQuestions(String id, String q_text, double marks, String type, String answer, String studentAnswer) {
        super(id, q_text, marks, type, answer);
        this.studentAnswer = studentAnswer;
    }

    public SolvedQuestions(Question question, String studentAnswer) {
       this.question = question;
       this.studentAnswer = studentAnswer;

    }


    public String getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer) {
        studentAnswer = studentAnswer;
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public String getAnswer() {
        return question.getAnswer();
    }

    @Override
    public String getChoice1() {
        return super.getChoice1();
    }

    @Override
    public void setChoice1(String choice1) {
        super.setChoice1(choice1);
    }

    @Override
    public String getChoice2() {
        return super.getChoice2();
    }

    @Override
    public void setChoice2(String choice2) {
        super.setChoice2(choice2);
    }

    @Override
    public String getChoice3() {
        return super.getChoice3();
    }

    @Override
    public void setChoice3(String choice3) {
        super.setChoice3(choice3);
    }

    @Override
    public void setAnswer(String answer) {
        super.setAnswer(answer);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
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
    public String getQ_text() {
        return question.getQ_text();
    }

    @Override
    public void setQ_text(String q_text) {
        super.setQ_text(q_text);
    }

    @Override
    public double getMarks() {
        return super.getMarks();
    }

    @Override
    public void setMarks(double marks) {
        super.setMarks(marks);
    }
}
