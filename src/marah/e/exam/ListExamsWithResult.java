package marah.e.exam;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListExamsWithResult extends Application {
    static Scene scene;
    Users user;

    public ListExamsWithResult(Users user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

         TableView<SolvedExams> tableView = new TableView<>();

         TableColumn<SolvedExams, String> examName = new TableColumn("Exam Name");
         examName.setCellValueFactory(new PropertyValueFactory<>("name"));

         TableColumn<SolvedExams, String> examResult = new TableColumn("Exam Result");
         examResult.setCellValueFactory(new PropertyValueFactory<>("result"));

         TableColumn<SolvedExams, Integer> totalMarksColumn = new TableColumn<>("Total Marks");
         totalMarksColumn.setCellValueFactory(new PropertyValueFactory<>("marks"));


        tableView.getColumns().addAll(examName, examResult, totalMarksColumn);

        for (int i = 0; i < user.exams.size(); i++) {
            tableView.getItems().add(user.exams.get(i));
        }

        try {
            examName.setCellFactory(column -> {
                return new TableCell<SolvedExams, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            setText(item);
                            setOnMouseClicked(event -> {
                                // perform action on cell click
                                System.out.println("Clicked on cell with value: " + item);
                                SolvedExams solvedExam = null;
                                for (int i = 0; i < Utils.solvedExams.size(); i++) {
                                    if (Utils.solvedExams.get(i).getName().equals(item)){
                                        solvedExam = Utils.solvedExams.get(i);
                                    }
                                }
                                new ShowMyResult(solvedExam).start(primaryStage);

                            });
                        } else {
                            setText(null);
                            setOnMouseClicked(null);
                        }
                    }
                };
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
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
