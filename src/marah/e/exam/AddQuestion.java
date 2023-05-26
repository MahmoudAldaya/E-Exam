package marah.e.exam;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddQuestion extends Application {
    static Scene scene;

    public AddQuestion() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create UI components
        Label questionIdLabel = new Label("Question ID:");
        Label choiceOne = new Label("Choice one:");
        Label choiceTwo = new Label("Choice two:");
        Label choiceThree = new Label("Choice three:");

        TextField questionIdField = new TextField();
        TextField choiceOneText = new TextField();
        TextField choiceTwoText = new TextField();
        TextField choiceThreeText = new TextField();

        Label questionMarksLabel = new Label("Question Marks:");
        TextField questionMarksField = new TextField();

        Label questionTypeLabel = new Label("Question Type:");
        RadioButton MCQ = new RadioButton("MCQ");
        RadioButton TF = new RadioButton("TF");
        RadioButton FB = new RadioButton("FB");

        ToggleGroup questionTypeGroup = new ToggleGroup();

        MCQ.setToggleGroup(questionTypeGroup);
        TF.setToggleGroup(questionTypeGroup);
        FB.setToggleGroup(questionTypeGroup);

        Label questionTextLabel = new Label("Question Text:");
        TextArea questionTextArea = new TextArea();

        Label questionAnswerLabel = new Label("Question Answer:");
        TextField questionAnswerField = new TextField();

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


        // Create scene and set it in the stage
        scene = new Scene(gridPane);
        primaryStage.setTitle("Add Question");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
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
                            Utils.questions.add(new Question(questionIdField.getText(), questionTextArea.getText(), Double.parseDouble(questionMarksField.getText()), "MCQ", questionAnswerField.getText(), choiceOneText.getText(), choiceTwoText.getText(), choiceThreeText.getText()));
                            Utils.AddAlert("New " + selectedValue + " question has added");
                        } else {
                            Utils.AddAlert("Missing choices!");
                        }

                    } else if (selectedValue.equals("TF")) {
                        Utils.questions.add(new Question(questionIdField.getText(), questionTextArea.getText(), Double.parseDouble(questionMarksField.getText()), "TF", questionAnswerField.getText()));
                        Utils.AddAlert("New " + selectedValue + " question has added");


                    } else {
                        Utils.questions.add(new Question(questionIdField.getText(), questionTextArea.getText(), Double.parseDouble(questionMarksField.getText()), "FB", questionAnswerField.getText()));
                        Utils.AddAlert("New " + selectedValue + " question has added");
                    }

                } else {
                    Utils.AddAlert("Missing Inputs");
                }
            }else
                Utils.AddAlert("Missing Inputs");


        });

        cancelButton.setOnAction(actionEvent -> {
            primaryStage.setScene(TeacherUI.scene);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }


}


