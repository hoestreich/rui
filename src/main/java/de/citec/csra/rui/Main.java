/**
 * ============================================================
 *
 * This file is a part of the de-citec-csra-rui project
 *
 * Copyright (C) 2015 Citec, Bielefeld University
 *
 * This program is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General
 * Public License as published by the Free Software Foundation;
 * either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * ============================================================
 */
package de.citec.csra.rui;

import java.util.logging.Logger;

import rsb.Informer;

import com.guigarage.responsive.ResponsiveHandler;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author hoestreich
 *
 */
public class Main extends Application {

    private static final Logger LOG = Logger
            .getLogger(Informer.class.getName());

    private final int screenwidth = 400;
    private final int screenheight = 400;

    @Override
    public void start(final Stage primaryStage) {
        try {
            StackPane root = new StackPane();
            Scene scene = new Scene(root, screenwidth, screenheight);
            scene.getStylesheets().add(
                    getClass().getResource("application.css").toExternalForm());

            Image image = new Image(
                    Main.class.getResourceAsStream("LSP-CSRA_Map_2D_basic.png"));
            ImageView imageView = new ImageView();
            imageView.setFitHeight(screenheight - 80);
            imageView.setFitWidth(screenwidth - 80);
            // imageView.setViewport(new Rectangle2D(40, 40, 100, 100));
            imageView.setImage(image);
            imageView.setOnZoom(new EventHandler<ZoomEvent>() {
                @Override
                public void handle(ZoomEvent event) {
                    imageView.setScaleX(imageView.getScaleX()
                            * event.getZoomFactor());
                    imageView.setScaleY(imageView.getScaleY()
                            * event.getZoomFactor());
                    LOG.info("Rectangle: Zoom event" + ", inertia: "
                            + event.isInertia() + ", direct: "
                            + event.isDirect());

                    event.consume();
                }
            });
            HBox hbox = new HBox();
            hbox.getChildren().addAll(imageView);
            VBox vbox = new VBox();
            vbox.getChildren().addAll(hbox);
            vbox.getStyleClass().addAll("visible-lg", "visible-md");

            Label label = new Label();
            label.setText("Fenster zu klein");
            label.getStyleClass().addAll("visible-xs", "visible-sm");

            root.getChildren().addAll(vbox, label);
            primaryStage.setScene(scene);
            primaryStage.show();

            ResponsiveHandler.addResponsiveToWindow(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     *            argumentlist
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
