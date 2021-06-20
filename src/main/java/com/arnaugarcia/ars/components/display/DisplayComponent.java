package com.arnaugarcia.ars.components.display;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
public class DisplayComponent extends Pane {

    @Setter
    private EventHandler<MouseEvent> myEventHandler;
    private final DisplayController controller;
    private final String identifier;
    private final Integer displayHeight;
    private final Integer displayWidth;
    private final Boolean mainDisplay;

    @Builder
    public DisplayComponent(String identifier,
                            Integer displayHeight,
                            Integer displayWidth,
                            Boolean mainDisplay,
                            EventHandler<MouseEvent> onClickAction) {
        super();
        this.identifier = identifier;
        this.displayHeight = displayHeight;
        this.displayWidth = displayWidth;
        this.mainDisplay = mainDisplay;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/display.fxml"));
        controller = new DisplayController();
        loader.setController(controller);
        try {
            Node node = loader.load();
            this.getChildren().add(node);
            controller.getDisplay().setWidth(displayWidth);
            controller.getDisplay().setHeight(displayHeight);

            controller.getMainDisplay().setVisible(mainDisplay);
            controller.getMainDisplay().setWidth(displayWidth);

            controller.getIdentifier().setText(this.identifier);
            controller.setMyEventHandler(onClickAction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
