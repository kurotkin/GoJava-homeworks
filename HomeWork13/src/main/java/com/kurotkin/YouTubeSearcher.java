package com.kurotkin;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Vitaly Kurotkin on 20.09.2017.
 */
public class YouTubeSearcher extends Application {
    public static void main(String[] args) throws UnirestException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("key.txt"));
        String key = reader.readLine();


        com.mashape.unirest.http.HttpResponse<JsonNode> r = Unirest.get("https://www.googleapis.com/youtube/v3/search")
                .queryString("part", "snippet")
                .queryString("maxResults", "24")
                .queryString("q", "КОШКА")
                .queryString("key", key)
                .asJson();
        System.out.println(r.getBody().toString());
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final Pane root = new Pane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);
        primaryStage.setTitle(this.getClass().getName());

        final TextField searchField = new TextField("Search");
        searchField.setTranslateX(10);
        searchField.setTranslateY(10);
        searchField.setPrefWidth(800);

        final Button button = new Button("Search");
        button.setTranslateX(820);
        button.setTranslateY(10);

        root.getChildren().addAll(searchField, button);
        primaryStage.show();
    }
}
