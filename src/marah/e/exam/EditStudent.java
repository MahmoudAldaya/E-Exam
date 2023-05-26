package marah.e.exam;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class EditStudent extends Application {
static Scene scene;
Users student;

    public EditStudent(Users student) {
        this.student = student;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button back = new Button("Back");
        back.setPrefSize(100, 30);
        back.setStyle("-fx-background-color: pink;");


        Label usernamelbl = new Label("Username");
        Label passwordlbl = new Label("Password");
        Label birthdaylbl = new Label("Birthday");
        Label namelbl = new Label("Name");
        Label uniIDlbl = new Label("Uni. ID");
        Label genderlbl = new Label("Gender");


        TextField username = new TextField();
        TextField password = new TextField();
        TextField birthday = new TextField();
        TextField name = new TextField();
        TextField uniId = new TextField();
        TextField gender = new TextField();

        username.setEditable(false);
        uniId.setEditable(false);
        gender.setEditable(false);

        Button edit = new Button("edit");
        edit.setPrefSize(100, 30);
        edit.setStyle("-fx-background-color: pink;");


        VBox labels = new VBox(47);
        labels.getChildren().addAll(usernamelbl, passwordlbl,
                birthdaylbl, namelbl, uniIDlbl, genderlbl);

        labels.setAlignment(Pos.CENTER);

        VBox texts = new VBox(30);
        texts.getChildren().addAll(username, password, birthday,
                name, uniId, gender);

        texts.setAlignment(Pos.CENTER);

        HBox boxes = new HBox(30);
        boxes.getChildren().addAll(labels, texts);

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(edit, back);
        buttons.setAlignment(Pos.CENTER);

        VBox v = new VBox(20);
        v.getChildren().addAll(boxes, buttons);

        boxes.setAlignment(Pos.CENTER);
        v.setAlignment(Pos.CENTER);


        for (Node node : labels.getChildren()) {
            // Check if the node is a Button
            if (node instanceof Label) {
                // Cast the node to a Button
                Label label = (Label) node;

                // Perform whatever operation you need to on the button
                label.setStyle("-fx-font-size: 20;");
            }
        }

        for (Node node : texts.getChildren()) {
            // Check if the node is a Button
            if (node instanceof TextField) {
                // Cast the node to a Button
                TextField text = (TextField) node;

                // Perform whatever operation you need to on the button
                text.setStyle("-fx-font-size: 20;");
            }
        }

        username.setText(student.getUsername());
        password.setText(student.getPassword());
        birthday.setText(student.getBirthday());
        name.setText(student.getName());
        uniId.setText(student.getUni_id());
        gender.setText(student.getGender());



      edit.setOnAction(actionEvent -> {
          student.setName(name.getText());
          student.setPassword(password.getText());
          student.setBirthday(birthday.getText());

          Utils.AddAlert("Edited!");
      });

        back.setOnAction(actionEvent -> {
            primaryStage.setScene(StudentUI.scene);
        });

        scene = new Scene(v, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

