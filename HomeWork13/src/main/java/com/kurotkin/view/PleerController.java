package com.kurotkin.view;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;

/**
 * Created by Vitaly Kurotkin on 03.10.2017.
 */
public class PleerController {
    @FXML
    private WebView webView;

    public void showVideo(String videoId) {
        String url = "http://www.youtube.com/embed/" + videoId + "?autoplay=1";
        webView.getEngine().load(url);
        webView.setPrefSize(640, 390);
    }
}
