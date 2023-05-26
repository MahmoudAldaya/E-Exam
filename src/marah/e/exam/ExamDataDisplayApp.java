package marah.e.exam;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;


public class ExamDataDisplayApp extends Application {
    int invoker;
    Stage stage;
    static Scene scene;
    Exams exam;

    public ExamDataDisplayApp(int invoker) {
        this.invoker = invoker;
    }
    public ExamDataDisplayApp() {
    }



    private TableView<Exams> examTable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;


        // Create the TableView for displaying exam data
        examTable = new TableView<>();

        // Create the columns for exam data
        TableColumn<Exams, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Exams, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Exams, Integer> numQuestionsColumn = new TableColumn<>("Number of Questions");
        numQuestionsColumn.setCellValueFactory(new PropertyValueFactory<>("numOfQuestions"));
        numQuestionsColumn.setPrefWidth(180);

        TableColumn<Exams, Double> minPassAverageColumn = new TableColumn<>("Min Pass Average");
        minPassAverageColumn.setCellValueFactory(new PropertyValueFactory<>("min_pass_average"));
                minPassAverageColumn.setPrefWidth(180);


        TableColumn<Exams, Integer> totalMarksColumn = new TableColumn<>("Total Marks");
        totalMarksColumn.setCellValueFactory(new PropertyValueFactory<>("marks"));
                totalMarksColumn.setPrefWidth(150);


        // Add the columns to the table
        examTable.getColumns().addAll(idColumn, nameColumn, numQuestionsColumn, minPassAverageColumn, totalMarksColumn);

        // Create the VBox layout and add the table
        VBox root = new VBox(20, examTable);
        root.setAlignment(Pos.CENTER);

        Button back = new Button("Back");
        back.setPrefSize(70, 30);
        back.setStyle("-fx-font-size: 15;");

        root.getChildren().add(back);

        back.setOnAction(actionEvent -> {
            if (invoker == 0){ // teacher
                primaryStage.setScene(TeacherUI.scene);

            }else if (invoker == 1){ // student
                primaryStage.setScene(StudentUI.scene);
            }

        });

        // Create the main Scene
        scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Exam Data Display");
        primaryStage.show();

        // Populate the table with exam data
        populateExamData();


    }

    private void populateExamData() { // this will get all exams in the Utils.exam array and list them in the table
        for (int i = 0; i < Utils.exams.size(); i++) {
            examTable.getItems().add(Utils.exams.get(i));
        }
    }

}

