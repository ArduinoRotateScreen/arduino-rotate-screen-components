package com.arnaugarcia.ars.components.display;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
public class DisplayComponent extends Pane {

    @Setter
    private EventHandler<MouseEvent> onClickHandler;
    private final DisplayController controller;
    private final String identifier;
    private final int displayHeight;
    private final int displayWidth;
    private final boolean mainDisplay;
    private final boolean selected;

    @Builder
    public DisplayComponent(String identifier,
                            int displayHeight,
                            int displayWidth,
                            boolean mainDisplay,
                            boolean selected,
                            EventHandler<MouseEvent> onClickAction) {
        super();
        this.identifier = identifier;
        this.displayHeight = displayHeight;
        this.displayWidth = displayWidth;
        this.mainDisplay = mainDisplay;
        this.selected = selected;
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

            if (selected) {
                controller.getDisplay().setFill(Color.RED);
            }

            controller.setOnClickHandler(onClickAction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
