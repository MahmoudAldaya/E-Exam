package marah.e.exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ViewTeachers extends Application {

    static Scene scene;

    private Stage primaryStage;
    private TableView<Users> teacherTable = new TableView<>();

    private ObservableList<Users> teacherData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;


        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setCenter(createCenterPane());
        root.setBottom(createBottomPane());

        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Example Interface with Back Button");
        primaryStage.show();
    }

    private TableView createCenterPane() {

        TableColumn<Users, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Users, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<Users, Integer> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Users, Integer> birthdayColumn = new TableColumn<>("Birthday");
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        TableColumn<Users, Integer> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Users, Integer> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Users, Integer> specialtyColumn = new TableColumn<>("Specialty");
        specialtyColumn.setCellValueFactory(new PropertyValueFactory<>("specialty"));

        teacherTable.getColumns().addAll(usernameColumn, passwordColumn, nameColumn, birthdayColumn, genderColumn, salaryColumn, specialtyColumn);

        teacherData.addAll(Utils.getUserType(0));
        teacherTable.setItems(teacherData);

        return teacherTable;
    }

    private HBox createBottomPane() {
        HBox bottomPane = new HBox();
        bottomPane.setAlignment(Pos.CENTER_RIGHT);
        bottomPane.setPadding(new Insets(10));
        bottomPane.setSpacing(10);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            // Handle back button click
                primaryStage.setScene(AdminUI.scene);

        });
        bottomPane.getChildren().add(backButton);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> {
            // Handle close button click
            primaryStage.close();
        });
        bottomPane.getChildren().add(closeButton);

        return bottomPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}