package com.kurotkin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kurotkin.youtube.entities.ActivityResponce;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


/**
 * Created by Vitaly Kurotkin on 20.09.2017.
 */
public class YouTubeSearcher extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    public static void main(String[] args) throws UnirestException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("key.txt"));
        String key = reader.readLine();


        HttpResponse<ActivityResponce> r = Unirest.get("https://www.googleapis.com/youtube/v3/search")
                .queryString("part", "snippet")
                .queryString("maxResults", "24")
                .queryString("q", "КОШКА")
                .queryString("key", key)
                .asObject(ActivityResponce.class);
        ActivityResponce activity = r.getBody();

        System.out.println(activity.items.get(0).snippet.title);
        //launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Search in Youtube");
        initLayout();
    }

    private void initLayout() {
        URL url = getClass().getResource("/YoutubeDialog.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        try {
            rootLayout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Url is " + url);
        }
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        this.primaryStage = primaryStage;
//        this.primaryStage.setTitle("Search in Youtube");
//        rootLayout = new BorderPane();
//        rootLayout.setPrefSize(1200, 600);
//
//        Pane pane = new Pane();
//        final TextField searchField = new TextField("Search");
//        searchField.setLayoutX(14);
//        searchField.setLayoutY(18);
//        searchField.setPrefWidth(1111);
//
//        final Button button = new Button("Search");
//        button.setLayoutX(1134);
//        button.setLayoutY(18);
//
//        pane.getChildren().addAll(searchField,button);
//
//
//        TableView table = new TableView();
//        TableColumn c1 = new TableColumn("Название видео");
//        TableColumn c2 = new TableColumn("Название канала");
//        TableColumn c3 = new TableColumn("Дата публикации");
//        TableColumn c4 = new TableColumn("Изображение из видео");
//        TableColumn c5 = new TableColumn("Название видео");
//        TableColumn c6 = new TableColumn("Название видео");
//
//
//        rootLayout.setTop(pane);
//
//        primaryStage.setScene(new Scene(rootLayout));
//        primaryStage.show();
//    }


    @Override
    public void stop() throws Exception {
        Unirest.shutdown();
    }
}
