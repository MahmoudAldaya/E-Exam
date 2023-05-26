package marah.e.exam;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;


public class AddExam extends Application {
    int count = 0;
    private static Stage stage;
    private static Scene examScene, questionsScene;
    private TextField numQuestionsField, minPassAvgField, allowedTypesField, examNameField;
    private Button createExamButton, addQuestionsButton;
    private Label numQuestionsLabel, minPassAvgLabel, allowedTypesLabel, examNameLabel;
    private int numQuestions, minPassAvg;
    private String allowedTypes;
    private ArrayList<Question> selectedQuestions = new ArrayList<>();;

    public AddExam() {
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("Add Exam");

        // Create exam scene
        examNameLabel = new Label("Exam name:");
        examNameField = new TextField();
        numQuestionsLabel = new Label("Number of Questions:");
        numQuestionsField = new TextField();
        minPassAvgLabel = new Label("Minimum Passing Average:");
        minPassAvgField = new TextField();
        allowedTypesLabel = new Label("Allowed Question Type:");
        allowedTypesField = new TextField();
        allowedTypesField.setPromptText("Available types are: 'MCQ', 'TF' and 'FB'");
        createExamButton = new Button("Create Exam");
        Button back = new Button("Back");

        createExamButton.setOnAction(e -> createExam());

//        createExamButton.setOnAction(actionEvent -> {
//            createExam();
//        });

        back.setOnAction(actionEvent -> {
            primaryStage.setScene(TeacherUI.scene);
        });

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(createExamButton, back);
        hbox.setAlignment(Pos.CENTER);

        VBox examLayout = new VBox(10);
        examLayout.setAlignment(Pos.CENTER);
        examLayout.getChildren().addAll(examNameLabel, examNameField, numQuestionsLabel,
                numQuestionsField, minPassAvgLabel,
                minPassAvgField, allowedTypesLabel, allowedTypesField, hbox);

        for (Node node : examLayout.getChildren()) {
            // Check if the node is a Button
            if (node instanceof Label) {
                // Cast the node to a Button
                Label label = (Label) node;

                // Perform whatever operation you need to on the button
                label.setStyle("-fx-font-size: 20; -fx-alignment: center");
                label.setPrefSize(400, 30);
            }
            else if(node instanceof TextField){
                // Cast the node to a Button
                TextField tfield = (TextField) node;

                // Perform whatever operation you need to on the button
                tfield.setStyle("-fx-font-size: 20;");
                tfield.setPrefSize(200, 30);
                tfield.setMaxWidth(400);
            }
        }

        examScene = new Scene(examLayout, 800, 600);

        // Create questions scene
        addQuestionsButton = new Button("Add Questions");


        VBox questionsLayout = new VBox(10);
        questionsLayout.setAlignment(Pos.CENTER);
        questionsLayout.getChildren().add(addQuestionsButton);
        questionsScene = new Scene(questionsLayout, 800, 600);

        primaryStage.setScene(examScene);
        primaryStage.show();
    }

    private void createExam() {
        // Get exam information from input fields
        if (numQuestionsField.getText().length()!=0 && minPassAvgField.getText().length()!=0 &&
                examNameField.getText().length()!=0 && allowedTypesField.getText().length()!=0) {

            numQuestions = Integer.parseInt(numQuestionsField.getText());
            minPassAvg = Integer.parseInt(minPassAvgField.getText());
            allowedTypes = allowedTypesField.getText();

            // Switch to questions scene
            stage.setScene(addQuestions());
        }
        else{
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error Dialog");
//            alert.setHeaderText("Missing Inputs");
//            alert.setContentText("Please fill all the required fields.");
//            alert.showAndWait();

              Utils.AddAlert("Missing Inputs");

        }
    }

    private Scene addQuestions() {
        // Generate questions based on exam information
        Button createExam = new Button("Create exam");
        Button back = new Button("Back");

        ObservableList<Question> tquestions = FXCollections.observableArrayList();
       // String id, String q_text, double marks, String type, String answer
        // Create table columns
        TableColumn<Question, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Question, Integer> marksCol = new TableColumn<>("Marks");
        marksCol.setCellValueFactory(new PropertyValueFactory<>("marks"));

        TableColumn<Question, String> textCol = new TableColumn<>("Question Text");
        textCol.setCellValueFactory(new PropertyValueFactory<>("q_text"));

        TableColumn<Question, String> answerCol = new TableColumn<>("Answer");
        answerCol.setCellValueFactory(new PropertyValueFactory<>("answer"));

        TableColumn<Question, String> choice1Col = new TableColumn<>("Choice1");
        choice1Col.setCellValueFactory(new PropertyValueFactory<>("choice1"));

        TableColumn<Question, String> choice2Col = new TableColumn<>("Choice2");
        choice2Col.setCellValueFactory(new PropertyValueFactory<>("choice2"));

        TableColumn<Question, String> choice3Col = new TableColumn<>("Choice3");
        choice3Col.setCellValueFactory(new PropertyValueFactory<>("choice3"));

        // Create table view
        TableView<Question> table = new TableView<>();
        tquestions.addAll(generateQuestions());
        table.setItems(tquestions);
        table.getColumns().addAll(idCol, marksCol, textCol, answerCol, choice1Col, choice2Col, choice3Col);

        try {
            idCol.setCellFactory(column -> {
                return new TableCell<Question, String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            setText(item);
                            setOnMouseClicked(event -> {
                                // perform action on cell click
                                System.out.println("Clicked on cell with value: " + item);
                                for (int i = 0; i < Utils.questions.size(); i++) {
                                    if (Utils.questions.get(i).getId().equals(item)) {
                                        selectedQuestions.add(Utils.questions.get(i));
                                    }
                                }

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

        createExam.setOnAction(actionEvent -> { // this is 'create exam' button
                int totalMarksCounter = 0;

            for (int i = 0; i < selectedQuestions.size(); i++) {
                totalMarksCounter += selectedQuestions.get(i).getMarks();
            }
                if (selectedQuestions.size() == numQuestions) { // case one --> user entered the correct number ...
                    count++;

                    Utils.exams.add(new Exams(examNameField.getText(), "2020", totalMarksCounter, Integer.parseInt(numQuestionsField.getText()), Integer.parseInt(minPassAvgField.getText()), selectedQuestions, allowedTypesField.getText()));
                    Utils.AddAlert("new exam added");

                    for (int i = 0; i < Utils.exams.size(); i++) {
                        System.out.println(Utils.exams.get(i).getName());
                    }

                    stage.setScene(AddExam.examScene);

                } else if(selectedQuestions.size() > numQuestions){  // user entered more than allowed
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Too much questions");
                    alert.setContentText("Please choose "+numQuestions +" questions");
                    alert.showAndWait();

                    selectedQuestions.clear();
                }
                else{ // user entered less than allowed
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Not enough questions");
                    alert.setContentText("Please choose "+numQuestions +" questions");
                    alert.showAndWait();

                }
        });

        // Create layout and scene
        HBox hBox = new HBox(20, createExam, back);
        hBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(table, hBox);
        root.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(root, 800, 600);

        back.setOnAction(actionEvent -> {
            stage.setScene(AddExam.examScene);
        });


        return scene2;
    }

    private ArrayList<Question> generateQuestions() { // will fill the table with all allowed exams

        ArrayList<Question> questions = new ArrayList<>();

        for (int i = 0; i < Utils.questions.size(); i++) {
            if(Utils.questions.get(i).getType().equals(allowedTypes)){
                questions.add(Utils.questions.get(i));
            }
        }

        return questions;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

