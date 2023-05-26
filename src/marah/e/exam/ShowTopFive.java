package marah.e.exam;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowTopFive extends Application {
    static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableView<Users> tableView = new TableView<>();

        TableColumn<Users, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn<Users, String> resultCol = new TableColumn<>("Result");
        resultCol.setCellValueFactory(new PropertyValueFactory("result"));

        tableView.getColumns().addAll(nameCol, resultCol);

        for (int i = 0; i < Utils.getUserType(1).size(); i++) {
            tableView.getItems().add(Utils.getUserType(1).get(i));
        }

        Button back = new Button("Back");
        VBox vBox = new VBox(20, tableView, back);
        vBox.setAlignment(Pos.CENTER);

        back.setOnAction(actionEvent -> {
            primaryStage.setScene(StudentUI.scene);
        });

        scene = new Scene(vBox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
