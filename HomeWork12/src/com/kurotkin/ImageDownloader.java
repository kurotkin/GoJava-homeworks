package com.kurotkin;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Vitaly Kurotkin on 19.09.2017.
 */
public class ImageDownloader extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(800);
        primaryStage.setWidth(700);
        primaryStage.setTitle("Загрузка кошек из интернета");
        Pane root = new Pane();
        final Button button = new Button("Загрузить");
        button.setTranslateX(10);
        button.setTranslateY(10);

        root.getChildren().add(genGrid());
        root.getChildren().add(button);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        button.setOnMouseClicked(click -> {
            root.getChildren().clear();
            root.getChildren().add(genGrid());
            root.getChildren().add(button);
        });
    }

    public static GridPane genGrid(){
        Callable<GridPane> loadImages = new Callable<GridPane>(){
            @Override
            public GridPane call() throws Exception {
                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.setPadding(new Insets(70,30,30,30));
                grid.setHgap(5);
                grid.setVgap(5);

                List<ImageView> images = new ArrayList<>();
                for(int i = 0; i < 25; i++){
                    Image image = null;
                    try {
                        image = new Image(Cats.getRandomUrl().openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    images.add(new ImageView(image));
                }
                for(int i = 0; i < 25; i++) {
                    grid.add(images.get(i), i % 5, i / 5);
                }
                return grid;
            }
        };
        try {
            return loadImages.call();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
