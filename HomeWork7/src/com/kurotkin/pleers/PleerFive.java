package com.kurotkin.pleers;

/**
 * Created by Kurotkin Vitaly on 04.08.2017.
 */
public class PleerFive extends PleerThree{

    public PleerFive(int price, String[] songs) {
        super(price, songs);
        pleerName = "Pleer 5";
    }

    @Override
    public void playAllSongs () {
        System.out.println(pleerName);
        for (int i = playlist.length - 1; i >= 0; i--) {
            playSong(i);
        }
    }

}
