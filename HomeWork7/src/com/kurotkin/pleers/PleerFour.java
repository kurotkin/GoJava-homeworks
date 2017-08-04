package com.kurotkin.pleers;

/**
 * Created by Kurotkin Vitaly on 04.08.2017.
 */
public class PleerFour extends PleerThree{

    public PleerFour(int price, String[] songs) {
        super(price, songs);
        pleerName = "Pleer 4";
    }

    @Override
    public void playSong() {
        System.out.println(pleerName);
        playSong(playlist.length - 1);
    }

}
