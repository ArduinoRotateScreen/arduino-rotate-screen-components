package com.arnaugarcia.ars.components.display;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
public class DisplayController implements Initializable {

    @Setter
    private EventHandler<MouseEvent> onClickHandler;

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
        setIdentifierAtCenter();
    }

    private void setIdentifierAtCenter() {
        identifier.layoutXProperty()
                .bind(display.widthProperty()
                .subtract(identifier.widthProperty())
                .divide(2));
    }

    @FXML
    public void click(MouseEvent event) {
        if (onClickHandler != null) {
            onClickHandler.handle(event);
        }
    }
}
