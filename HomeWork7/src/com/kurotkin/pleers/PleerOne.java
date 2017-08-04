package com.kurotkin.pleers;

/**
 * Created by Kurotkin Vitaly on 03.08.2017.
 */
public class PleerOne extends Pleer {
    public PleerOne(int price, String oneSongName) {
        super(price);
        pleerName = "Pleer 1";
        playlist = new String[1];
        playlist[0] = oneSongName;
    }

    public void playSong() {
        super.playSong();
    }
}
