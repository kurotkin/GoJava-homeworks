package com.kurotkin.model;

import com.kurotkin.youtube.entities.Activity;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Андрей on 29.09.2017.
 */
public class Video {
    private final ObjectProperty<LocalDate> publishedAt;
    private final StringProperty description;
    private final StringProperty title;
    private final StringProperty url;

    public Video(Activity activity) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.from(f.parse(activity.snippet.publishedAt));
        this.publishedAt = new SimpleObjectProperty<LocalDate>(dateTime);
        this.description = new SimpleStringProperty(activity.snippet.description);
        this.title = new SimpleStringProperty(activity.snippet.title);
        this.url = new SimpleStringProperty(activity.snippet.thumbnails.high.url);
    }
}
