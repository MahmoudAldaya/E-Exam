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

public class ShowMyResult extends Application {
    SolvedExams exam;

    public ShowMyResult(SolvedExams exam) {
        this.exam = exam;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TableView<SolvedQuestions> tableView = new TableView<>();

        TableColumn<SolvedQuestions, String> questionText = new TableColumn<>("Question");
        questionText.setCellValueFactory(new PropertyValueFactory<>("q_text"));

        TableColumn<SolvedQuestions, String> questionAnswer = new TableColumn<>("Question Answer");
        questionAnswer.setCellValueFactory(new PropertyValueFactory<>("answer"));

        TableColumn<SolvedQuestions, String> studentAnswer = new TableColumn<>("My Answer");
        studentAnswer.setCellValueFactory(new PropertyValueFactory<>("studentAnswer"));

        tableView.getColumns().addAll(questionText, questionAnswer);

        for (int i = 0; i < Utils.solvedExams.size(); i++) {
            if (Utils.solvedExams.get(i).getName().equals(exam.getName())){
                exam = Utils.solvedExams.get(i);
            }
        }


        try{
        for (int i = 0; i < exam.solvedQuestions.size(); i++) {
                tableView.getItems().add(exam.solvedQuestions.get(i));
        }
        }catch (Exception e){
        Utils.AddAlert("Unexpected error");
            System.out.println(e.getMessage());
    }


        Button back = new Button("Back");

        back.setOnAction(actionEvent -> {
            primaryStage.setScene(ListExamsWithResult.scene);
        });

        VBox root = new VBox(20, tableView, back);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
