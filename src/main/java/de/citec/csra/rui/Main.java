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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author hoestreich
 *
 */
public class Main extends Application {

    private final int screenwidth = 400;
    private final int screenheight = 400;
    @Override
    public void start(final Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, screenwidth, screenheight);
            scene.getStylesheets()
                 .add(getClass()
                 .getResource("application.css")
                 .toExternalForm());

            Image image = new Image("http://docs.oracle.com/javafx/"
                    + "javafx/images/javafx-documentation.png");
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            root.getChildren().add(imageView);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args argumentlist
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
