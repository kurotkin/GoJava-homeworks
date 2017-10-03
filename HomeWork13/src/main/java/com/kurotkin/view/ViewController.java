package com.kurotkin.view;

import com.kurotkin.YouTubeSearcher;
import com.kurotkin.youtube.Net;
import com.kurotkin.youtube.entities.Activity;
import com.kurotkin.youtube.entities.Snippet;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created by Vitaly Kurotkin on 29.09.2017.
 */
public class ViewController {
    @FXML
    private TableView<Snippet> personTable;
    @FXML
    private TableColumn<Snippet, String> publishedAtColumn;
    @FXML
    private TableColumn<Snippet, String> descriptionColumn;
    @FXML
    private TableColumn<Snippet, String> titleColumn;

    @FXML
    GridPane searchOutPane;
    @FXML
    TextField searchText;

    private YouTubeSearcher mainClass;

    @FXML
    public void runSearch() {
        searchOutPane.getChildren().clear();
        searchOutPane.setGridLinesVisible(true);
        Net youTobeSearch = new Net();

        List<Activity> resultList = youTobeSearch.getResult(searchText.getText(), mainClass.key).items;

        for (int i = 0; i < resultList.size(); i++) {
            VBox vBox = new VBox();
            vBox.getChildren().addAll(new Label("Наиминование канала: " + resultList.get(i).snippet.channelTitle));
            vBox.getChildren().addAll(new Label("Наиминование видео: " + resultList.get(i).snippet.title));
            vBox.getChildren().addAll(new Label("Дата публикации: " + resultList.get(i).snippet.publishedAt.getTime()));

            ImageView imageView = new ImageView();

            final String imageUrl = resultList.get(i).snippet.thumbnails.medium.url;
            Thread thread = new Thread(()->{
                imageView.setImage(getImage(imageUrl));
            });
            thread.start();

            searchOutPane.add(imageView,0,i);
            searchOutPane.add(vBox,1,i);
            Button button = new Button("View");
            searchOutPane.add(button,2,i);
            final String videoId = resultList.get(i).id.videoId;
            button.setOnMouseClicked(event -> {
                mainClass.showPlayerScene(videoId);
            });
        }
    }

    public void setMain(YouTubeSearcher mainClass) {
        this.mainClass = mainClass;
    }

    private Image getImage(String urlString) {
        Image image = null;
        try {
            URL url = new URL(urlString);
            image = new Image(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
