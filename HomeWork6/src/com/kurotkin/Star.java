package com.kurotkin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Created by Vitaly on 31.07.17.
 */
public class Star extends Application {
    private Pane root = new Pane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);

        drawStar(400,400 ,100);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawStar(int x, int y, double rad) {

        double a = 0;
        double b = Math.PI / 5.0;
        double k = 0.35;
        int x1 = x + (int)(rad * Math.cos(a));
        int x2;
        int y1 = y + (int)(rad * Math.sin(a));
        int y2;

        for (int i = 0; i < 5; i++) {
            a = a + b;
            y2 = y + (int)(k * rad * Math.sin(a));
            x2 = x + (int)(k * rad * Math.cos(a));
            Line line1 = new Line(x1, y1, x2, y2);

            a = a + b;
            x1 = x + (int)(rad * Math.cos(a));
            y1 = y + (int)(rad * Math.sin(a));
            Line line2 = new Line(x1, y1, x2, y2);
            root.getChildren().addAll(line1, line2);
        }

    }
}
