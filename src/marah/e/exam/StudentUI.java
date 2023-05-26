package marah.e.exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentUI extends Application {
    static Scene scene;
    Users user;

    public StudentUI(Users user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        /**
         * start new exam
         * edit information
         * view all result
         * show top five students
         */

        Button startExam = new Button("Start new exam");
        Button editInformation = new Button("Edit student's info");
        Button viewAllResults = new Button("View all results");
        Button showTopFiveStudents = new Button("Show top five students");

        Button back = new Button("Logout");
        back.setPrefSize(100, 30);
        back.setStyle("-fx-font-size: 20;");

        Label label = new Label("Students Main Menu");
        label.setPrefSize(500, 30);
        label.setStyle("-fx-font-size: 20; -fx-background-color: pink; -fx-padding: 20; -fx-alignment: center;");

        Label signed = new Label();
        signed.setText("Signed as "+user.getName());
        signed.setStyle("-fx-font-size: 14; -fx-background-color: pink; -fx-padding: 10; -fx-alignment: center;");


        VBox buttons = new VBox(30);
        buttons.getChildren().add(signed);
        buttons.getChildren().add(label);
        buttons.getChildren().addAll(startExam, editInformation, viewAllResults, showTopFiveStudents);
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
        scene = new Scene(buttons, 800, 600);
        stage.setScene(scene);
        stage.show();


        back.setOnAction(actionEvent -> {
            stage.setScene(LoginScreen.scene);
        });

        startExam.setOnAction(actionEvent -> {
            new StartExam().start(stage);
        });

        editInformation.setOnAction(actionEvent -> {
            Users student = null;
            for (int i = 0; i < Utils.getUserType(1).size(); i++) {
                if (Utils.getUserType(1).get(i).getUsername().equals(LoginScreen.usernameText)){
                    student = Utils.getUserType(1).get(i);
                }
            }
            new EditStudent(student).start(stage);
        });

            viewAllResults.setOnAction(actionEvent -> {
                Users e = null;
                for (int i = 0; i < Utils.getUserType(1).size(); i++) {
                    if (Utils.getUserType(1).get(i).getUsername().equals(LoginScreen.usernameText)) {
                        e = Utils.getUserType(1).get(i);
                    }
                }
                try {
                    new ListExamsWithResult(e).start(stage);
                } catch (Exception ex) {
                    Utils.AddAlert("User don't have any exams to display!");

                }
            });


        showTopFiveStudents.setOnAction(actionEvent -> {
            new ShowTopFive().start(stage);
        });
    }
}
