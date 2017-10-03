package com.kurotkin.youtube.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Vitaly Kurotkin on 29.09.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnails {
    public High high;
    public Medium medium;
}
