package com.kurotkin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
    private List<myRectangle> rectangles;
    private boolean singlThread;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        Pane root = new Pane();
        final Button button1 = new Button("Multy Threads");
        final Button button2 = new Button("Single Thread");
        button1.setTranslateX(10);
        button1.setTranslateY(10);
        button2.setTranslateX(110);
        button2.setTranslateY(10);

        root.getChildren().addAll(button1);
        root.getChildren().addAll(button2);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        button1.setOnMouseClicked(event -> {
            rectangles = getRectangles();
            for(myRectangle r : rectangles) {
                root.getChildren().add(r.rectangle);
                Thread thread = new Thread(() -> {
                    while(!singlThread) {
                        Platform.runLater(() -> {
                            r.moveX();
                            r.moveY();
                        });
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

        button2.setOnMouseClicked(event -> {
            singlThread = true;
            Thread thread = new Thread(() -> {
                while(singlThread) {
                    for(myRectangle r : rectangles) {
                        Platform.runLater(() -> {
                            double x = myRectangle.moveX(r);
                            double y = myRectangle.moveY(r);
                            r.rectangle.setX(x);
                            r.rectangle.setY(y);
                        });
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        });

    }

    private static List<myRectangle> getRectangles () {
        List<myRectangle> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(new myRectangle());
        return list;
    }

    private static class myRectangle {
        public Rectangle rectangle;
        private double dirMovX;
        private double dirMovY;
        private double step = 1;

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
            Color color = Color.color(
                    random.nextDouble(),
                    random.nextDouble(),
                    random.nextDouble());
            rectangle.setFill(Paint.valueOf(color.toString()));
            dirMovX = random.nextBoolean() ? 1 : -1;
            dirMovY = random.nextBoolean() ? 1 : -1;
        }

        public void moveX(){
            final double x = rectangle.getX() + dirMovX * step;
            if(x >= (width - rectangle.getWidth())){
                dirMovX = -1;
            }
            if(x <= 0){
                dirMovX = 1;
            }
            rectangle.setX(x);
        }

        public void moveY(){
            final double y = rectangle.getY() + dirMovY * step;
            if(y >= (height - rectangle.getHeight())){
                dirMovY = -1;
            }
            if(y <= 0){
                dirMovY = 1;
            }
            rectangle.setY(y);
        }

        public static double moveX(myRectangle r){
            final double x = r.rectangle.getX() + r.dirMovX * r.step;
            if(x >= (width - r.rectangle.getWidth())){
                r.dirMovX = -1;
            }
            if(x <= 0){
                r.dirMovX = 1;
            }
            return x;
        }

        public static double moveY(myRectangle r){
            final double y = r.rectangle.getY() + r.dirMovY * r.step;
            if(y >= (height - r.rectangle.getHeight())){
                r.dirMovY = -1;
            }
            if(y <= 0){
                r.dirMovY = 1;
            }
            return y;
        }
    }
}
