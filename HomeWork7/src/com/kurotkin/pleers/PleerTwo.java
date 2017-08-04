package com.kurotkin.pleers;

/**
 * Created by Kurotkin Vitaly on 03.08.2017.
 */
public class PleerTwo extends PleerOne {

    public PleerTwo(int price, String oneSongName) {
        super(price, oneSongName);
        pleerName = "Pleer 2";
    }

    public void playSong() {
        System.out.println(pleerName);
        System.out.println("error");
    }
}
