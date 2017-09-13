package com.kurotkin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Vitaly on 13.09.2017.
 */
public class GeometryInMotion extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        Pane root = new Pane();
        final Button button = new Button("Multy Threads");
        button.setTranslateX(10);
        button.setTranslateY(10);

        root.getChildren().addAll(button);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(20);

        final Thread thread = new Thread(() -> {
            while(true) {
                final double x = button.getTranslateX() + 2;
                System.out.println("х=" + x);

                Platform.runLater(() -> {
                    button.setTranslateX(x);
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        button.setOnMouseClicked(event -> {
            thread.start();
        });
    }

    //public static class
}
