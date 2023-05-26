package marah.e.exam;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EditQuestion extends Application {

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
        primaryStage.setX(150);
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

        TableColumn<Question, String> answerCol = new TableColumn<>("Answer");
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
                                Question question = null;

                                for (int i = 0; i < Utils.questions.size(); i++) {
                                    if (Utils.questions.get(i).getId().equals(item)){
                                        question = Utils.questions.get(i);
                                    }
                                }

                                stage.setScene(editPage(question));

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


        // Create layout and scene
        Label note = new Label();
        note.setText("To edit a question just click on its ID...");
        note.setStyle("-fx-font-size: 20; -fx-background-color: pink");
        VBox root = new VBox(20,note, table, back);
        root.setAlignment(Pos.CENTER);
        Scene scene2 = new Scene(root, 1350, 600);

        back.setOnAction(actionEvent -> {
            stage.setScene(TeacherUI.scene);
        });


        return scene2;
    }

    private ArrayList<Question> generateQuestions() { // will fill the table with all questions
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < Utils.questions.size(); i++) {
            questions.add(Utils.questions.get(i));
        }
        return questions;
    }


    public Scene editPage(Question question){
        Label questionIdLabel = new Label("Question ID:");
        Label choiceOne = new Label("Choice one:");
        Label choiceTwo = new Label("Choice two:");
        Label choiceThree = new Label("Choice three:");

        TextField questionIdField = new TextField();
        questionIdField.setText(question.getId());
        TextField choiceOneText = new TextField();
        choiceOneText.setText(question.getChoice1());
        TextField choiceTwoText = new TextField();
        choiceTwoText.setText(question.getChoice2());
        TextField choiceThreeText = new TextField();
        choiceThreeText.setText(question.getChoice3());


        Label questionMarksLabel = new Label("Question Marks:");
        TextField questionMarksField = new TextField();
        questionMarksField.setText(question.getMarks()+"");

        Label questionTypeLabel = new Label("Question Type:");
        RadioButton MCQ = new RadioButton("MCQ");
        RadioButton TF = new RadioButton("TF");
        RadioButton FB = new RadioButton("FB");
        ToggleGroup questionTypeGroup = new ToggleGroup();
        MCQ.setToggleGroup(questionTypeGroup);
        TF.setToggleGroup(questionTypeGroup);
        FB.setToggleGroup(questionTypeGroup);
        if (question.getType().equals("FB")){
            FB.setSelected(true);
        }else if (question.getType().equals("MCQ")){
            MCQ.setSelected(true);
        }else
            TF.setSelected(true);

        Label questionTextLabel = new Label("Question Text:");
        TextArea questionTextArea = new TextArea();
        questionTextArea.setText(question.getQ_text());

        Label questionAnswerLabel = new Label("Question Answer:");
        TextField questionAnswerField = new TextField();
        questionAnswerField.setText(question.getAnswer());

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Back");

        // Create layout and add UI components
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(questionIdLabel, 0, 0);
        gridPane.add(questionIdField, 1, 0);

        gridPane.add(questionMarksLabel, 0, 1);
        gridPane.add(questionMarksField, 1, 1);

        gridPane.add(questionTypeLabel, 0, 2);
        gridPane.add(MCQ, 1, 2);
        gridPane.add(TF, 2, 2);
        gridPane.add(FB, 3, 2);

        VBox choicesLabels = new VBox(30);
        choicesLabels.getChildren().addAll(choiceOne, choiceTwo, choiceThree);

        VBox choicesText = new VBox(20);
        choicesText.getChildren().addAll(choiceOneText, choiceTwoText, choiceThreeText);


        HBox box = new HBox(20);
        box.getChildren().addAll(questionTextArea, choicesLabels, choicesText);

        gridPane.add(questionTextLabel, 0, 3);
        gridPane.add(box, 1, 3, 3, 1);

        gridPane.add(questionAnswerLabel, 0, 4);
        gridPane.add(questionAnswerField, 1, 4);

        gridPane.add(saveButton, 1, 5);
        gridPane.add(cancelButton, 2, 5);


        // String id, String q_text, double marks, String type, String answer
        saveButton.setOnAction(actionEvent -> {
            if (questionAnswerField.getText().length()!=0 && questionIdField.getText().length()!=0 &&
                    questionTextArea.getText().length()!=0 && questionMarksField.getText().length()!=0) {

                RadioButton selectedRadioButton = (RadioButton) questionTypeGroup.getSelectedToggle();
                String selectedValue = selectedRadioButton.getText();

                if (questionAnswerField.getText().length() != 0 && questionIdField.getText().length() != 0 &&
                        questionTextArea.getText().length() != 0 && questionMarksField.getText().length() != 0) {


                    if (selectedValue.equals("MCQ")) {
                        if (choiceOneText.getText().length() != 0 && choiceTwoText.getText().length() != 0 && choiceThreeText.getText().length() != 0) {
                           // Utils.questions.add(new Question(questionIdField.getText(), questionTextArea.getText(), Double.parseDouble(questionMarksField.getText()), "MCQ", questionAnswerField.getText(), choiceOneText.getText(), choiceTwoText.getText(), choiceThreeText.getText()));
                            question.setId(questionIdField.getText());
                            question.setAnswer(questionAnswerField.getText());
                            question.setMarks(Double.parseDouble(questionMarksField.getText()));
                            question.setQ_text(questionTextArea.getText());
                            question.setChoice1(choiceOneText.getText());
                            question.setChoice2(choiceTwoText.getText());
                            question.setChoice3(choiceThreeText.getText());
                            question.setType("MCQ");
                            Utils.AddAlert("Question Edited Successfully!");
                        } else {
                            Utils.AddAlert("Missing choices!");
                        }

                    } else if (selectedValue.equals("TF")) {
                        question.setId(questionIdField.getText());
                        question.setAnswer(questionAnswerField.getText());
                        question.setMarks(Double.parseDouble(questionMarksField.getText()));
                        question.setQ_text(questionTextArea.getText());
                        question.setType("TF");

                        Utils.AddAlert("Question Edited Successfully!");


                    } else {
                        question.setId(questionIdField.getText());
                        question.setAnswer(questionAnswerField.getText());
                        question.setMarks(Double.parseDouble(questionMarksField.getText()));
                        question.setQ_text(questionTextArea.getText());
                        question.setType("FB");

                        Utils.AddAlert("Question Edited Successfully!");
                    }

                } else {
                    Utils.AddAlert("Missing Inputs");
                }
            }else
                Utils.AddAlert("Missing Inputs");
        });

        cancelButton.setOnAction(actionEvent -> {
            stage.setScene(EditQuestion.scene);
        });

        return new Scene(gridPane);
    }
}

