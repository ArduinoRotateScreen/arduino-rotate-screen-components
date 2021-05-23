package com.arnaugarcia.ars.components.display;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import lombok.Getter;

import java.io.IOException;

@Getter
public class DisplayComponent extends Pane {

    private final DisplayController controller;
    protected SimpleStringProperty identifier = new SimpleStringProperty();
    protected ObjectProperty<Integer> displayHeight = new SimpleObjectProperty<>();
    protected ObjectProperty<Integer> displayWidth = new SimpleObjectProperty<>();
    protected ObjectProperty<Boolean> mainDisplay = new SimpleObjectProperty<>();

    public DisplayComponent() {
        super();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/display.fxml"));
        controller = new DisplayController();
        loader.setController(controller);
        try {
            Node node = loader.load();
            this.getChildren().add(node);
            /*controller.getDisplay().setWidth(displayWidth.get());
            controller.getDisplay().setHeight(displayHeight.get());

            controller.getMainDisplay().setVisible(isMainDisplay());
            controller.getMainDisplay().setWidth(displayWidth.get());*/

            controller.getIdentifier().setText(identifier.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getIdentifier() {
        return identifier.get();
    }

    public void setIdentifier(String identifier) {
        this.identifier.set(identifier);
    }

    public Integer getDisplayHeight() {
        return displayHeight.get();
    }

    public void setDisplayHeight(Integer displayHeight) {
        this.displayHeight.set(displayHeight);
    }

    public Integer getDisplayWidth() {
        return displayWidth.get();
    }

    public void setDisplayWidth(Integer displayWidth) {
        this.displayWidth.set(displayWidth);
    }

    public Boolean getMainDisplay() {
        return mainDisplay.get();
    }

    public void setMainDisplay(Boolean mainDisplay) {
        this.mainDisplay.set(mainDisplay);
    }

    private Boolean isMainDisplay() {
        return mainDisplay.getValue();
    }
}
