package marah.e.exam;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminUI extends Application {
 static Scene scene;
 Users user;

    public AdminUI(Users user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        /**
         * add teacher
         * add student
         * list all teachers
         * list all students
         */
        Button back = new Button("Logout");
        back.setPrefSize(120, 30);
        back.setStyle("-fx-font-size: 20; -fx-text-fill: black");

        Button addTeacher = new Button("Add new teacher");
        Button addStudent = new Button("Add new student");
        Button listTeachers = new Button("List all teachers");
        Button listStudents = new Button("List all students");

        Label label = new Label("Admin Main Menu");
        label.setPrefSize(500, 30);
        label.setStyle("-fx-font-size: 20; -fx-background-color: pink; -fx-padding: 20; -fx-alignment: center;");

        Label signed = new Label();
        signed.setText("Signed as admin");
        signed.setStyle("-fx-font-size: 14; -fx-background-color: pink; -fx-padding: 10; -fx-alignment: center;");

        VBox buttons = new VBox(30);
        buttons.getChildren().add(signed);
        buttons.getChildren().add(label);
        buttons.getChildren().addAll(addTeacher, addStudent, listTeachers, listStudents);
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

        addTeacher.setOnAction(actionEvent -> {
            new AddTeacher().start(stage);

        });

        addStudent.setOnAction(actionEvent -> {
            new AddStudent(0).start(stage);
        });

        listTeachers.setOnAction(actionEvent -> {
            new ViewTeachers().start(stage);

        });

        listStudents.setOnAction(actionEvent -> {
            new ViewStudents(0).start(stage);
        });

        back.setOnAction(actionEvent -> {
            stage.setScene(LoginScreen.scene);
        });

        scene = new Scene(buttons, 800, 600);
        stage.setScene(scene);
        stage.show();

    }
}

