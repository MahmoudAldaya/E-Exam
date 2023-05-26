package marah.e.exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartExam extends Application { // This screen lists all available exams to start...
static Scene scene;

    public StartExam() {
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a list of objects
        ObservableList<String> items = FXCollections.observableArrayList();

        for (int i = 0; i < Utils.exams.size(); i++) {
            items.add(Utils.exams.get(i).getName());
        }

        // Create a ListView and set the items
        ListView<String> listView = new ListView<>(items);

        // Add a click event listener to the ListView
        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Exams e = null;
                for (int i = 0; i < Utils.exams.size(); i++) {
                    if (selectedItem.equals(Utils.exams.get(i).getName()) || selectedItem.equals(Utils.exams.get(i).getId())){
                        e = Utils.exams.get(i);
                    }
                }

               new StartExamScreen(e).start(primaryStage);
            }
        });

        // Create a layout container and add the ListView to it
        Button back = new Button("Back");
        VBox root = new VBox(20, listView, back);
        root.setAlignment(Pos.CENTER);

        back.setOnAction(actionEvent -> {
            primaryStage.setScene(StudentUI.scene);
        });

        // Create the scene and set it on the stage
        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ListView Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
