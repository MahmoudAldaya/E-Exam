package marah.e.exam;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddStudent extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    static Scene scene;
    int invoker;

    public AddStudent(int invoker) {
        this.invoker = invoker;
    }

    @Override
    public void start(Stage stage) {
        /**
         * String username,
         * String password,
         * String birthday,
         * String name,
         * String uni_id,
         * String gender
         */

        Button back = new Button("Back");
        back.setPrefSize(100, 30);
        back.setStyle("-fx-background-color: pink;");

        Label usernamelbl = new Label("Username");
        Label passwordlbl = new Label("Password");
        Label birthdaylbl = new Label("Birthday");  // choose a date from calender
        Label namelbl = new Label("Name");
        Label uniIDlbl = new Label("Uni. ID");
        Label genderlbl = new Label("Gender");  // radio buttons


        TextField username = new TextField();
        TextField password = new TextField();
        TextField birthday = new TextField();
        TextField name = new TextField();
        TextField uniId = new TextField();
        TextField gender = new TextField();

        Button add = new Button("Add");
        add.setPrefSize(100, 30);
        add.setStyle("-fx-background-color: pink;");


        VBox labels = new VBox(47);
        labels.getChildren().addAll(usernamelbl, passwordlbl, birthdaylbl, namelbl,
                uniIDlbl, genderlbl);

        labels.setAlignment(Pos.CENTER);

        VBox texts = new VBox(30);
        texts.getChildren().addAll(username, password, birthday, name, uniId, gender);

        texts.setAlignment(Pos.CENTER);

        HBox boxes = new HBox(30);
        boxes.getChildren().addAll(labels, texts);

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(add, back);
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

        /**
         * String username,
         * String password,
         * String birthday,
         * String name,
         * String uni_id,
         * String gender
         */

        add.setOnAction(actionEvent -> {
            try {
                if (username.getText().length() != 0 && password.getText().length() != 0 &&
                        birthday.getText().length() != 0 && name.getText().length() != 0 &&
                        uniId.getText().length() != 0 && gender.getText().length() != 0) {


                    Utils.users.add(new Users(username.getText(), password.getText(), birthday.getText(),
                            name.getText(), uniId.getText(), gender.getText(), new ArrayList<>(), 0));

                    Utils.clear(texts);
                    Utils.AddAlert("Added Successfully");
                }
                else{
                    Utils.AddAlert("Missing Inputs!");
                }

            }catch(Exception e){
                Utils.AddAlert("Input Mismatch!");
            }

        });


        scene = new Scene(v, 800, 600);
        stage.setScene(scene);
        stage.show();


        back.setOnAction(actionEvent -> {
            if (invoker == 0){
                stage.setScene(AdminUI.scene);
            }else
                stage.setScene(TeacherUI.scene);

        });

    }

}

