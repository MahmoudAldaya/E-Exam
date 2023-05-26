package marah.e.exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StartExamScreen extends Application {
    int counter = -1;
    Stage stage;
    int totalAnsweredMarks = 0;
    int totalMarks = 0;
    Exams exam;
    ArrayList<SolvedQuestions> solvedQuestions = new ArrayList<>();
    Users student;
    TextField answer;


    public StartExamScreen(Exams exam) {
        this.exam = exam;
    }

    @Override
    public void start(Stage stage) {
        try {
            this.stage = stage;

            for (int i = 0; i < Utils.getUserType(1).size(); i++) {
                if (LoginScreen.usernameText.equals(Utils.getUserType(1).get(i).getUsername())) {
                    student = Utils.getUserType(1).get(i);
                }
            }

            if (exam.getQuestionsType().equals("TF")) { // this handles tf case
                displayTFExam();
            } else if (exam.getQuestionsType().equals("FB")) { // this handle fb case
                displayFBExam();
            } else   // this handle mcq case
                displayMCQExam();

        }catch (Exception e){
            Utils.AddAlert("Unexpected error");
        }
    }

    public void displayTFExam(){
        Label examName = new Label();
        Label questionText = new Label();
        answer = new TextField();

        examName.setText(exam.getName());
        questionText.setText(exam.getQuestions().get(++counter).getQ_text());

        Button yes = new Button("Yes");
        Button no = new Button("No");
        Button next = new Button("Next");
        Button back = new Button("Back");

        yes.setOnAction(actionEvent -> {
            answer.setText("yes");
        });

        no.setOnAction(actionEvent -> {
            answer.setText("no");
        });

        solvedQuestions.add(new SolvedQuestions(exam.getQuestions().get(counter), answer.getText()));

        next.setOnAction(actionEvent -> {
            if (answer.getText().length()!=0) {
                totalMarks += exam.getQuestions().get(counter).getMarks();


                if (exam.getQuestions().get(counter).getAnswer().equals(answer.getText())) {
                    totalAnsweredMarks += exam.getQuestions().get(counter).getMarks();
                    Utils.AddAlert("Correct Answer");
                }else Utils.AddAlert("Wrong answer! \n"+ "The correct answer is: "+ exam.getQuestions().get(counter).getAnswer());

                if (counter < exam.getQuestions().size() - 1) {
                    displayTFExam();
                } else {

                    Utils.AddAlert("End of Questions \n" +
                            "Your result: " + totalAnsweredMarks + "/" + totalMarks);
                    next.setDisable(true);
                }
            }else
            Utils.AddAlert("Missing Answer!");

        });

        back.setOnAction(actionEvent -> {

                    student.exams.add(new SolvedExams(exam, totalAnsweredMarks, solvedQuestions, student.getName()));
                    Utils.solvedExams.add(new SolvedExams(exam, totalAnsweredMarks, solvedQuestions, student.getName()));
                    student.setResult(student.result += totalAnsweredMarks);


            stage.setScene(StartExam.scene);
        });

        HBox hBox = new HBox(20, yes, no);
        hBox.setAlignment(Pos.CENTER);

        HBox controlButtons = new HBox(20, next, back);
        controlButtons.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, examName, questionText, hBox, answer, controlButtons);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void displayFBExam(){
        Label examName = new Label();
        Label questionText = new Label();
        answer = new TextField();

        examName.setText(exam.getName());
        questionText.setText(exam.getQuestions().get(++counter).getQ_text());

        Button next = new Button("Next");
        Button back = new Button("Back");


        solvedQuestions.add(new SolvedQuestions(exam.getQuestions().get(counter), answer.getText()));

        next.setOnAction(actionEvent -> {
            if (answer.getText().length()!=0) {
                totalMarks += exam.getQuestions().get(counter).getMarks();

                if (exam.getQuestions().get(counter).getAnswer().equalsIgnoreCase(answer.getText())) {
                    totalAnsweredMarks += exam.getQuestions().get(counter).getMarks();
                    Utils.AddAlert("Correct Answer");
                }else Utils.AddAlert("Wrong answer! \n"+ "The correct answer is: "+ exam.getQuestions().get(counter).getAnswer());

                if (counter < exam.getQuestions().size() - 1) {
                    displayFBExam();
                } else {
                    Utils.AddAlert("End of Questions \n" +
                            "Your result: " + totalAnsweredMarks + "/" + totalMarks);
                    next.setDisable(true);
                }
            }else
                Utils.AddAlert("Missing Answer!");

        });

        back.setOnAction(actionEvent -> {
            student.exams.add(new SolvedExams(exam, totalAnsweredMarks, solvedQuestions, student.getName()));
            Utils.solvedExams.add(new SolvedExams(exam, totalAnsweredMarks, solvedQuestions, student.getName()));
            student.setResult(student.result += totalAnsweredMarks);

            stage.setScene(StartExam.scene);

        });
        HBox controlButtons = new HBox(20, next, back);
        controlButtons.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, examName, questionText, answer, controlButtons);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void displayMCQExam(){
        Label examName = new Label();
        Label questionText = new Label();
        answer = new TextField();

        examName.setText(exam.getName());
        questionText.setText(exam.getQuestions().get(++counter).getQ_text());

        Button choice1 = new Button(exam.getQuestions().get(counter).getChoice1());
        Button choice2 = new Button(exam.getQuestions().get(counter).getChoice2());
        Button choice3 = new Button(exam.getQuestions().get(counter).getChoice3());
        Button next = new Button("Next");
        Button back = new Button("Back");

        choice1.setOnAction(actionEvent -> {
            answer.setText(exam.getQuestions().get(counter).getChoice1());
        });

        choice2.setOnAction(actionEvent -> {
            answer.setText(exam.getQuestions().get(counter).getChoice2());
        });

        choice3.setOnAction(actionEvent -> {
            answer.setText(exam.getQuestions().get(counter).getChoice3());
        });

        solvedQuestions.add(new SolvedQuestions(exam.getQuestions().get(counter), answer.getText()));

        next.setOnAction(actionEvent -> {
            if (answer.getText().length()!=0) {
                totalMarks += exam.getQuestions().get(counter).getMarks();

                if (exam.getQuestions().get(counter).getAnswer().equals(answer.getText())) {
                    totalAnsweredMarks += exam.getQuestions().get(counter).getMarks();
                    Utils.AddAlert("Correct Answer");
                }else Utils.AddAlert("Wrong answer! \n"+ "The correct answer is: "+ exam.getQuestions().get(counter).getAnswer());

                if (counter < exam.getQuestions().size() - 1) {
                    displayMCQExam();
                } else {
                    Utils.AddAlert("End of Questions \n" +
                            "Your result: "+totalAnsweredMarks +"/"+ totalMarks);
                    next.setDisable(true);
                }
            }else
                Utils.AddAlert("Missing Answer!");
        });


            back.setOnAction(actionEvent -> {

                student.exams.add(new SolvedExams(exam, totalAnsweredMarks, solvedQuestions, student.getName()));
                Utils.solvedExams.add(new SolvedExams(exam, totalAnsweredMarks, solvedQuestions, student.getName()));
                student.setResult(student.result += totalAnsweredMarks);

                stage.setScene(StartExam.scene);
            });

        HBox hBox = new HBox(20, choice1, choice2, choice3);
        hBox.setAlignment(Pos.CENTER);

        HBox controlButtons = new HBox(20, next, back);
        controlButtons.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20, examName, questionText, hBox, answer, controlButtons);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

}

