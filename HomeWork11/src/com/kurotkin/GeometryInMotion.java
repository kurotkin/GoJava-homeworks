package com.kurotkin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vitaly on 13.09.2017.
 */
public class GeometryInMotion extends Application {
    private static final Random random = new Random();
    private static final int width = 800;
    private static final int height = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        Pane root = new Pane();
        final Button button = new Button("Multy Threads");
        button.setTranslateX(10);
        button.setTranslateY(10);

        root.getChildren().addAll(button);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        button.setOnMouseClicked(event -> {
            List<myRectangle> rectangles = getRectangles();
            for(myRectangle r : rectangles) {
                root.getChildren().add(r.rectangle);

                Thread thread = new Thread(() -> {
                    while(true) {
                        r.move();

                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });

    }

    private static List<myRectangle> getRectangles () {
        List<myRectangle> list = new ArrayList<>();
        for (int i = 1; i < 3; i++)
            list.add(new myRectangle());
        return list;
    }

    private static class myRectangle {
        public Rectangle rectangle;
        private int dirMovX;
        private int dirMovY;
        private int step = 1;

        public myRectangle() {
            int widthR = random.nextInt(width/4) + 4;
            int heightR = random.nextInt(height/4) + 4;
            int x = random.nextInt(width - widthR);
            int y = random.nextInt(height - heightR);
            rectangle = new Rectangle();
            rectangle.setX(x);
            rectangle.setY(y);
            rectangle.setWidth(widthR);
            rectangle.setHeight(heightR);
            dirMovX = random.nextBoolean() ? 1 : -1;
            dirMovY = random.nextBoolean() ? 1 : -1;
        }

        public void move(){
            final double x = rectangle.getTranslateX() + dirMovX * step;
            if(x < 0 || x > (width - rectangle.getWidth()))
                dirMovX *= -1;
            final double y = rectangle.getTranslateY() + dirMovY * step;
            if(y < 0 || y > (height - rectangle.getHeight()))
                dirMovY *= -1;
            Platform.runLater(() -> {
                rectangle.setTranslateX(x);
                rectangle.setTranslateY(y);
            });
        }
    }

    //public static class
}
