package com.arnaugarcia.ars.components.display;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import lombok.Getter;

import java.io.IOException;

@Getter
public class Display extends Pane {

    DisplayController controller;
    SimpleStringProperty identifier = new SimpleStringProperty();
    SimpleIntegerProperty displayHeight = new SimpleIntegerProperty();
    SimpleIntegerProperty displayWidth = new SimpleIntegerProperty();
    SimpleBooleanProperty isMainDisplay = new SimpleBooleanProperty();

    public Display() {
        super();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/display.fxml"));
        controller = new DisplayController();
        loader.setController(controller);
        try {
            Node node = loader.load();
            this.getChildren().add(node);
            controller.getDisplay().setWidth(displayWidth.get());
            controller.getDisplay().setHeight(displayHeight.get());

            controller.getMainDisplay().setVisible(isMainDisplay());
            controller.getMainDisplay().setWidth(displayWidth.get());

            controller.getIdentifier().setText(identifier.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean isMainDisplay() {
        return isMainDisplay.getValue();
    }
}
