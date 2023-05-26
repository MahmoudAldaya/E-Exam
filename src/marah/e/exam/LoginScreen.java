package marah.e.exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;


public class LoginScreen extends Application {
    static Scene scene;
    static String usernameText;
    static String passwordText;

    @Override
    public void start(Stage stage) throws IOException {
        Utils.fillTheData();

        Button Exit = new Button("Exit");
        Exit.setPrefSize(120, 30);
        Exit.setStyle("-fx-font-size: 20; -fx-text-fill: black");

        Button login = new Button("Login");
        login.setPrefSize(120, 30);
        login.setStyle("-fx-font-size: 20; -fx-text-fill: black");

        TextField username = new TextField();
        username.setPrefSize(200, 30);
        username.setFont(new Font("corbel", 20));

        TextField password = new PasswordField();
        password.setPrefSize(200, 30);
        password.setFont(new Font("corbel", 20));

        Label userlbl = new Label("Username");
        Label passlbl = new Label("Password");
        passlbl.setStyle("-fx-font-size: 25; -fx-text-fill: black;");
        userlbl.setStyle("-fx-font-size: 25; -fx-text-fill: black;");

        GridPane root = new GridPane();
        root.getChildren().add(login);

        VBox lbls = new VBox(20);
        lbls.getChildren().add(userlbl);
        lbls.getChildren().add(passlbl);
        lbls.setAlignment(Pos.CENTER);

        VBox txts = new VBox(20);
        txts.getChildren().add(username);
        txts.getChildren().add(password);
        txts.setAlignment(Pos.CENTER);

        HBox hbox = new HBox(20);
        hbox.getChildren().addAll(lbls, txts);
        hbox.setAlignment(Pos.CENTER);

        HBox buttons = new HBox(20);
        buttons.getChildren().addAll(login, Exit);
        buttons.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(30);
        vbox.getChildren().addAll(hbox, buttons);
        vbox.setAlignment(Pos.CENTER);

        root.getChildren().add(vbox);
        root.setAlignment(Pos.CENTER);


        login.setOnAction(actionEvent -> {
        passwordText = password.getText();
        usernameText = username.getText();

        boolean flag = true;

            for(Users user: Utils.users){
                if(user.getUsername().equals(usernameText) && user.getPassword().equals(passwordText) && user.getUserType() == 1){
                    Utils.AddAlert("Ahlaan ya "+ user.getName());
                    new StudentUI(user).start(stage);
                    flag = false;
                    break;
                }
                else if (user.getUsername().equals(usernameText) && user.getPassword().equals(passwordText) && user.getUserType() == 0){
                    Utils.AddAlert("Welcome T. "+ user.getName());
                    new TeacherUI(user).start(stage);
                    flag = false;
                    break;
                }
                else if (usernameText.equals("admin") && passwordText.equals("admin")){
                    Utils.AddAlert("Ahlaan ya Rayyes");
                    new AdminUI(user).start(stage);
                    flag = false;
                    break;
                }
            }

            if (flag) Utils.AddAlert("Invalid login, please try again");
        });

        Exit.setOnAction(actionEvent -> {
            stage.close();
        });


        scene = new Scene(root,800, 600);
        stage.setTitle("E - Examination System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}