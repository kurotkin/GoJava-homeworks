package com.kurotkin.youtube.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Vitaly Kurotkin on 29.09.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityResponce {
    public List<Activity> items;
}
