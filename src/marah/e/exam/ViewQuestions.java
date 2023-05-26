package marah.e.exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewQuestions extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage stage;
    static Scene scene;
    @Override
    public void start(Stage primaryStage) {
    stage = primaryStage;

    scene = getQuestions();
    primaryStage.setScene(scene);
    primaryStage.show();
    }

    private Scene getQuestions() {
        // Generate questions based on exam information
        Button back = new Button("Back");
        ArrayList<Question> questions = generateQuestions();

        ObservableList<Question> tquestions = FXCollections.observableArrayList();
        // String id, String q_text, double marks, String type, String answer
        // Create table columns
        TableColumn<Question, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Question, Integer> marksCol = new TableColumn<>("Marks");
        marksCol.setCellValueFactory(new PropertyValueFactory<>("marks"));

        TableColumn<Question, String> textCol = new TableColumn<>("Question Text");
        textCol.setCellValueFactory(new PropertyValueFactory<>("q_text"));

        TableColumn<Question, String> answerCol = new TableColumn<>("     Answer      ");
        answerCol.setCellValueFactory(new PropertyValueFactory<>("answer"));

        TableColumn<Question, String> typeCol = new TableColumn<>("Question Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Question, String> choice1Col = new TableColumn<>("        Choice1        ");
        choice1Col.setCellValueFactory(new PropertyValueFactory<>("choice1"));

        TableColumn<Question, String> choice2Col = new TableColumn<>("        Choice2        ");
        choice2Col.setCellValueFactory(new PropertyValueFactory<>("choice2"));

        TableColumn<Question, String> choice3Col = new TableColumn<>("        Choice3        ");
        choice3Col.setCellValueFactory(new PropertyValueFactory<>("choice3"));

        // Create table view
        TableView<Question> table = new TableView<>();
        tquestions.addAll(generateQuestions());
        table.setItems(tquestions);
        table.getColumns().addAll(idCol, marksCol, textCol, answerCol,typeCol, choice1Col, choice2Col, choice3Col);


        // Create layout and scene
        VBox root = new VBox(20, table, back);
        root.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(root, 1200, 600);

        back.setOnAction(actionEvent -> {
            stage.setScene(TeacherUI.scene);
        });

        return scene2;
    }

    private ArrayList<Question> generateQuestions() { // will fill the table with all allowed questions
        ArrayList<Question> questions = new ArrayList<>();

        for (int i = 0; i < Utils.questions.size(); i++) {
                questions.add(Utils.questions.get(i));
        }
        return questions;
    }
}
