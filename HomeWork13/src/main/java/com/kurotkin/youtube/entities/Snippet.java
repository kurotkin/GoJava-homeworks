package com.kurotkin.youtube.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Calendar;

/**
 * Created by Vitaly Kurotkin on 29.09.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Snippet {
    public Calendar publishedAt;
    public String description;
    public String title;
    public String channelTitle;
    public Thumbnails thumbnails;
}
