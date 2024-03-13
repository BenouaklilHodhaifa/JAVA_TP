package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;

import java.io.IOException;

public class DefintionView {

    @FXML
    private Label phraseToDefine;

    @FXML
    private TextField answer;

    @FXML
    private Button Back;

    @FXML
    private Button Submit;

    @FXML
    private HBox word_box;

    private Parent root ;

    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Definition.fxml"));
        loader.setController(this);
        root = loader.load();
    }

    public void activate(Stage stage, EventHandler<ActionEvent> onClickBack){
        if(stage != null ){
            stage.getScene().setRoot(root);
            Back.setOnAction(onClickBack);
            stage.show();
        }
    }

    public void setPhraseToDefine(String phrase){
        phraseToDefine.setText(phrase);
    }

    public void setHbox(int motSize ){
        int len= motSize;
        for (int i = 0; i < len; i++) {
            TextField textField=new TextField();
            textField.setId(String.valueOf(i));
            textField.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
                String newText = change.getControlNewText();
                if (newText.length() > 1) {
                    return null ;
                } else {
                    return change ;
                }
            }));
            word_box.getChildren().add(textField);
        }

        for (int i = 0; i < len; i++) {
            TextField textField= (TextField) word_box.getChildren().get(i);
            textField.setOnKeyTyped(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (textField.getText().length() != 0 && !word_box.getChildren().get(len-1).isFocused() ){
                        Robot robot=new Robot();
                        robot.keyPress(KeyCode.TAB);
                        robot.keyRelease(KeyCode.TAB);
                    }
                }
            });
        }

    }

    public HBox getWord_box() {
        return word_box;
    }

    public Button getSubmit() {
        return Submit;
    }
}
