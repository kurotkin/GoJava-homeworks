package com.kurotkin;

import javafx.application.Application;
import javafx.application.Platform;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Vitaly Kurotkin on 19.09.2017.
 */
public class ImageDownloader extends Application{
    private static final String[] imageURLs = {
            "http://www.zoopicture.ru/assets/2014/09/12833908543_bbc6bf0e6f_z-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/08/IMG_60491-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/07/ashera_041-120x120.jpg",
            "http://www.zoopicture.ru/assets/2014/09/68e7fd1b1539-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/08/IMG_29471-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/10/IMG_43141-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/bombay-cat-photo1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/IMG_82381-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_31221-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_78271-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_882411-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/09/IMG_74321-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/01/IMG_04291-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/06/kip_051-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_1999-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/09/IMG_65841-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/IMG_4436_11-120x120.jpg",
            "http://www.zoopicture.ru/assets/2014/02/537612_431196850248596_1629331499_n-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/11/IMG_60441-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/07/mainecoon_101-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/06/IMG_9606_1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2011/02/IMG_95351-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/08/IMG_6455_1-120x120.jpg",
            "http://www.zoopicture.ru/assets/2013/02/3417712206_813d009d70_z-120x120.jpg",
            "http://www.zoopicture.ru/assets/2010/07/mirf_0190-120x120.jpg"};

    private static final Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(800);
        primaryStage.setWidth(700);

        Pane root = new Pane();

        final Button button = new Button("Загрузить");
        button.setTranslateX(10);
        button.setTranslateY(10);
        root.getChildren().add(button);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(70,30,30,30));
        grid.setHgap(5);
        grid.setVgap(5);

        List<ImageView> images = new ArrayList<>();
        for(int i = 0; i < 25; i++){
            int n = random.nextInt(imageURLs.length);
            URL url = new URL(imageURLs[n]);
            Image image = new Image(url.openStream());
            images.add(new ImageView(image));
        }
        for(int i = 0; i < 25; i++) {
            grid.add(images.get(i), i % 5, i / 5);
        }
        root.getChildren().add(grid);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        button.setOnMouseClicked(click -> {
            System.out.println(" + ");
            Platform.runLater(() -> {

            images.stream().forEach(im -> {
                int n = random.nextInt(imageURLs.length);
                URL url = null;
                try {
                    url = new URL(imageURLs[n]);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Image image = null;
                try {
                    image = new Image(url.openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                im.setImage(image);
            });
            });


//            grid.getChildren().clear();

//            System.out.println("+");
//
//                 = Stream.of(imageURLs).map(imageURL -> {
//                    try {
//                        return new URL(imageURL);
//                    } catch (MalformedURLException e) {
//                       e.printStackTrace();
//                      return null;
//                    }
//                }).collect(toList());
//
//                List<Image> imgs = new ArrayList<>();
//                while (urlList.size() != 0){
//
//                    try {
//                        imgs.add(new Image(urlList.get(n).openStream()));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    urlList.remove(n);
//                }
//                List<ImageView> images = imgs.stream().map(image -> new ImageView(image)).collect(toList());
//                images.stream().forEach(image -> {image.setFitWidth(120); image.setFitHeight(120);});
//
//            Platform.runLater(() -> {
//                for (int i = 0; i < images.size(); i++) {
//
//                    grid.add(images.get(i), i % 5, i / 5);
//
//
//                }
//
//            });
        });
    }
}
