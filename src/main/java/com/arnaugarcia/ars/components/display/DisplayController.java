package com.arnaugarcia.ars.components.display;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
public class DisplayController implements Initializable {

    @FXML
    private Pane root;

    @FXML
    private Rectangle display;

    @FXML
    private Rectangle mainDisplay;

    @FXML
    private Label identifier;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(identifier.getText());
    }


}
