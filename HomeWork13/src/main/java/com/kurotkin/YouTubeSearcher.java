package com.kurotkin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kurotkin.view.PleerController;
import com.kurotkin.view.ViewController;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;


/**
 * Created by Vitaly Kurotkin on 20.09.2017.
 */
public class YouTubeSearcher extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private static AnchorPane pleerLatout;
    public String key;

    public static void main(String[] args) throws UnirestException, IOException {
        launch(args);
    }

    public void loadKey(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("key.txt"));
            key = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        ViewController controller = loader.getController();
        this.loadKey();
        controller.setMain(this);
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }

    public void showPlayerScene(String videoId) {
        URL url = getClass().getResource("/Pleer.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        try {
            pleerLatout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Url is " + url);
        }

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Видео");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(pleerLatout);
        dialogStage.setScene(scene);
        PleerController controller = loader.getController();
        controller.showVideo(videoId);

        dialogStage.showAndWait();
    }


    @Override
    public void stop() throws Exception {
        Unirest.shutdown();
    }
}
