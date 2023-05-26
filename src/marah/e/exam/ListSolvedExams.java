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

public class ListSolvedExams extends Application {
    @Override
    public void start(Stage stage) {
        TableView<SolvedExams> tableView = new TableView<>();

        TableColumn<SolvedExams, String> examName = new TableColumn("Exam Name");
        examName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<SolvedExams, String> solverName = new TableColumn("Student Name");
        solverName.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn<SolvedExams, String> result = new TableColumn("result");
        result.setCellValueFactory(new PropertyValueFactory<>("result"));

        TableColumn<SolvedExams, String> totalResult = new TableColumn("Total Result");
        totalResult.setCellValueFactory(new PropertyValueFactory<>("marks"));

        tableView.getColumns().addAll(examName, solverName, result, totalResult);

        for (int i = 0; i < Utils.solvedExams.size(); i++) {
            tableView.getItems().add(Utils.solvedExams.get(i));
        }

        Button back = new Button("Back");
        back.setOnAction(actionEvent -> {
            stage.setScene(TeacherUI.scene);
        });

        VBox vBox = new VBox(20, tableView, back);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();

    }
}
