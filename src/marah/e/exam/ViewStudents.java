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

public class ViewStudents extends Application {
    int invoker;
    static Scene scene;

    public ViewStudents(int invoker) {
        this.invoker = invoker;
    }

    int userType;
    private Stage primaryStage;
    private TableView<Users> studentTable = new TableView<>();

    private ObservableList<Users> studentData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setCenter(createCenterPane()); // create a tableview
        root.setBottom(createBottomPane()); // back and close buttons

        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("View all students");
        primaryStage.show();
    }

    private TableView createCenterPane() {

        TableColumn<Users, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<Users, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        TableColumn<Users, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Users, String> uniIDColumn = new TableColumn<>("University ID");
        uniIDColumn.setCellValueFactory(new PropertyValueFactory<>("uni_id"));

        TableColumn<Users, String> birthdayColumn = new TableColumn<>("Birthday");
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        TableColumn<Users, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));


        studentTable.getColumns().addAll(usernameColumn, passwordColumn, nameColumn, uniIDColumn, birthdayColumn, genderColumn);
        studentData.addAll(Utils.getUserType(1));
        studentTable.setItems(studentData);

        return studentTable;
    }

    private HBox createBottomPane() {
        HBox bottomPane = new HBox();
        bottomPane.setAlignment(Pos.CENTER_RIGHT);
        bottomPane.setPadding(new Insets(10));
        bottomPane.setSpacing(10);

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            // Handle back button click
            if (invoker == 0){ //will go back to adminUI
                primaryStage.setScene(AdminUI.scene);
            }
            else
                primaryStage.setScene(TeacherUI.scene);

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

