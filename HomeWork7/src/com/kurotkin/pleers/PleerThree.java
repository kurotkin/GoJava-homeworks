package com.kurotkin.pleers;

/**
 * Created by Kurotkin Vitaly on 03.08.2017.
 */
public class PleerThree extends Pleer {
    public PleerThree(int price, String[] songs) {
        super(price);
        pleerName = "Pleer 3";
        playlist = songs;
    }

    public void playAllSongs () {
        System.out.println(pleerName);
        for (int i = 0; i < playlist.length; i++) {
            playSong(i);
        }
    }

}
