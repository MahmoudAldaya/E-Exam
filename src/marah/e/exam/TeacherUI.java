package marah.e.exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherUI extends Application {
    static Scene scene;
    Users user;

    public TeacherUI(Users user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        /**
         * add student
         * add question
         * add exams
         * list all students
         * list all exams
         */

        Button addStudent = new Button("Add new student");
        Button addQuestion = new Button("Add new question");
        Button addExam = new Button("Add new exam");
        Button listStudents = new Button("List all students");
        Button listExams = new Button("List all exams");
        Button listSolvedExams = new Button("List all solved exams");
        Button listQuestions = new Button("List all questions");

        Button back = new Button("Logout");
        back.setPrefSize(100, 30);
        back.setStyle("-fx-font-size: 20;");

        Label label = new Label("Teachers Main Menu");
        label.setPrefSize(500, 30);
        label.setStyle("-fx-font-size: 20; -fx-background-color: pink; -fx-padding: 20; -fx-alignment: center;");

        Label signed = new Label();
        signed.setText("Signed as "+user.getName());
        signed.setStyle("-fx-font-size: 14; -fx-background-color: pink; -fx-padding: 10; -fx-alignment: center;");

        VBox buttons = new VBox(30);
        buttons.getChildren().add(signed);
        buttons.getChildren().add(label);
        buttons.getChildren().addAll(addStudent, addQuestion, addExam, listStudents, listQuestions, listExams, listSolvedExams);
        buttons.setAlignment(Pos.CENTER);
        for (Node node : buttons.getChildren()) {
            // Check if the node is a Button
            if (node instanceof Button) {
                // Cast the node to a Button
                Button button = (Button) node;

                // Perform whatever operation you need to on the button
                button.setStyle("-fx-font-size: 20;");
                button.setPrefSize(300, 30);
            }
        }

        buttons.getChildren().add(back);

        addStudent.setOnAction(actionEvent -> {
            new AddStudent(1).start(stage);
        });

        listStudents.setOnAction(actionEvent -> {
            new ViewStudents(1).start(stage);
        });

        back.setOnAction(actionEvent -> {
            stage.setScene(LoginScreen.scene);
        });

        addQuestion.setOnAction(actionEvent -> {
            try {
                new AddQuestion().start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        addExam.setOnAction(actionEvent -> {
            new AddExam().start(stage);
        });

        listExams.setOnAction(actionEvent -> {
            new ExamDataDisplayApp(0).start(stage); // teacher
        });

        listQuestions.setOnAction(actionEvent -> {
            new EditQuestion().start(stage);
        });

        listSolvedExams.setOnAction(actionEvent -> {
            new ListSolvedExams().start(stage);
        });

        scene = new Scene(buttons, 800, 750);
        stage.setScene(scene);
        stage.show();

    }
}
