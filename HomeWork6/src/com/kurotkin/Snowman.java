package com.kurotkin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.Random;


public class Snowman extends Application {
    private Pane root = new Pane();
    private Circle[] circles;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        grafIntrf();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void grafIntrf () {
        Label countLabel = new Label("Snowbols count:");
        countLabel.setTranslateX(10);
        countLabel.setTranslateY(10);

        TextField countField = new TextField();
        countField.setTranslateX(10);
        countField.setTranslateY(30);
        countField.setText("8");

        Label minLabel = new Label("Minimal radius:");
        minLabel.setTranslateX(10);
        minLabel.setTranslateY(60);

        TextField minField = new TextField();
        minField.setTranslateX(10);
        minField.setTranslateY(80);
        minField.setText("5");

        Label maxLabel = new Label("Maximal radius:");
        maxLabel.setTranslateX(10);
        maxLabel.setTranslateY(110);

        TextField maxField = new TextField();
        maxField.setTranslateX(10);
        maxField.setTranslateY(130);
        maxField.setText("40");

        Button genButton = new Button("Generate");
        genButton.setTranslateX(10);
        genButton.setTranslateY(160);
        genButton.setOnMouseClicked(event -> {
            int nSnowBools = Integer.parseInt(countField.getText());
            int minRadius = Integer.parseInt(minField.getText());
            int maxRadius = Integer.parseInt(maxField.getText());
            clearSnowMan();
            root.getChildren().addAll(genCircles(nSnowBools, minRadius, maxRadius));
        });

        Button makeRedButton = new Button("Make red");
        makeRedButton.setTranslateX(10);
        makeRedButton.setTranslateY(190);
        makeRedButton.setOnMouseClicked(event -> {
            if (circles == null)
                return;
            for (Circle c : circles) {
                c.setFill(Paint.valueOf(Color.color(1,0,0).toString()));
            }
        });

        Button makeGradButton = new Button("Make gradient");
        makeGradButton.setTranslateX(10);
        makeGradButton.setTranslateY(220);
        makeGradButton.setOnMouseClicked(event -> {
            if (circles == null)
                return;
            double stepGrayColor = 1.0 / circles.length;
            for (int i = 0; i < circles.length; i++) {
                double grayColor = 1.0 - stepGrayColor * i;
                circles[i].setFill(Paint.valueOf(Color.color(grayColor,grayColor,grayColor).toString()));
            }
        });

        root.getChildren().addAll(countLabel, countField, minLabel, minField, maxLabel, maxField, genButton, makeRedButton, makeGradButton);
    }

    private Circle[] genCircles(int nSnowBools, int minRadius, int maxRadius) {
        circles = new Circle[nSnowBools + 3];
        for(int i = 0; i < circles.length; i++) {
            Color color = Color.color(
                    getRandom(0.0, 1.0),
                    getRandom(0.0, 1.0),
                    getRandom(0.0, 1.0));
            if(i == 0) {
                int randRad = getRandom(minRadius, maxRadius);
                circles[i] = new Circle(400, 100 + randRad, randRad,
                        Paint.valueOf(color.toString()));
            } else if (i == circles.length - 3) {
                int thirdRad = (int)circles[0].getRadius() / 3;
                int randRad =  getRandom(1, thirdRad);
                circles[i] = new Circle(400 - thirdRad,
                        (int)circles[0].getCenterY() - thirdRad,
                        randRad,
                        Paint.valueOf(color.toString()));
            } else if (i == circles.length - 2) {
                int thirdRad = (int)circles[0].getRadius() / 3;
                int randRad =  getRandom(1, thirdRad);
                circles[i] = new Circle(400 + thirdRad,
                        (int)circles[0].getCenterY() - thirdRad,
                        randRad,
                        Paint.valueOf(color.toString()));
            } else if (i == circles.length - 1) {
                int thirdRad = (int)circles[0].getRadius() / 3;
                int randRad =  getRandom(1, thirdRad);
                circles[i] = new Circle(400,
                        (int)circles[0].getCenterY() + thirdRad,
                        randRad,
                        Paint.valueOf(color.toString()));
            } else {
                int randRad = getRandom(minRadius, maxRadius);
                circles[i] = new Circle(400,
                        (int)circles[i-1].getCenterY() + (int)circles[i-1].getRadius() + randRad,
                        randRad,
                        Paint.valueOf(color.toString()));
            }
        }
        return circles;
    }

    private int getRandom (int min, int max) {
        Random random = new Random();
        return random.nextInt((max-min)) + min;
    }

    private double getRandom (double min, double max) {
        Random random = new Random();
        return random.nextDouble() * (max-min) + min;
    }

    private void clearSnowMan() {
        if (circles != null && circles.length > 0)
            root.getChildren().removeAll(circles);
    }
}
