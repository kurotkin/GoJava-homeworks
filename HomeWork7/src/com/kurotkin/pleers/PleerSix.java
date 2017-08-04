package com.kurotkin.pleers;

import java.util.Random;

/**
 * Created by Kurotkin Vitaly on 04.08.2017.
 */
public class PleerSix extends PleerThree{
    public PleerSix(int price, String[] songs) {
        super(price, songs);
        pleerName = "Pleer 6";
    }

    public void shuffle() {
        String[] newPlaylist = new String[playlist.length];
        for (int i = 0; i < newPlaylist.length; i++) {
            newPlaylist[i] = "null";
        }
        Random random = new Random();
        for (int i = 0; i < playlist.length; i++) {
            int r;
            do {
                r = random.nextInt(newPlaylist.length);
            } while (!newPlaylist[r].equals("null"));
           newPlaylist[r] = playlist[i];
        }
        playlist = newPlaylist;
    }
}
