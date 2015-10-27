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

import com.guigarage.responsive.ResponsiveHandler;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
            StackPane root = new StackPane();
            Scene scene = new Scene(root, screenwidth, screenheight);
            scene.getStylesheets()
                 .add(getClass()
                 .getResource("application.css")
                 .toExternalForm());

            Image image = new Image(Main.class.getResourceAsStream("LSP-CSRA_Map_2D_basic.png"));
            ImageView imageView = new ImageView();
            imageView.setFitHeight(screenheight-80);
            imageView.setFitWidth(screenwidth-80);
            //imageView.setViewport(new Rectangle2D(40, 40, 100, 100));
            imageView.setImage(image);
            
            Slider slider = new Slider();
            slider.setMin(0);
            slider.setMax(100);
            slider.setValue(40);
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);
            slider.setMajorTickUnit(50);
            slider.setMinorTickCount(5);
            slider.setBlockIncrement(10);
            slider.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                        Number old_val, Number new_val) {
                            //imageView.setViewport(new Rectangle2D(new_val.intValue(), imageView.getViewport().getMinY(), 100, 100));
                    }
                });
            Slider slider1 = new Slider();
            slider1.orientationProperty().set(Orientation.VERTICAL);
            slider1.setMin(0);
            slider1.setMax(100);
            slider1.setValue(40);
            slider1.setShowTickLabels(true);
            slider1.setShowTickMarks(true);
            slider1.setMajorTickUnit(50);
            slider1.setMinorTickCount(5);
            slider1.setBlockIncrement(10);
            slider1.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                        Number old_val, Number new_val) {
                            //imageView.setViewport(new Rectangle2D(imageView.getViewport().getMinX(), new_val.intValue(), 100, 100));
                    }
                });
            HBox hbox = new HBox();
            hbox.getChildren().addAll(imageView,slider1);
            VBox vbox = new VBox();
            vbox.getChildren().addAll(hbox, slider);
            vbox.getStyleClass().addAll("visible-lg", "visible-md");
            
            Label label = new Label();
            label.setText("Fenster zu klein");
            label.getStyleClass().addAll("visible-xs", "visible-sm");
            
            root.getChildren().addAll(vbox,label);
            primaryStage.setScene(scene);
            primaryStage.show();

            ResponsiveHandler.addResponsiveToWindow(primaryStage);
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
