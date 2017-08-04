package com.kurotkin;

import com.kurotkin.pleers.*;

public class Task1 {

    public static void main(String[] args) {
        PleerOne pleer1 = new PleerOne(123, "Одна песня");
        pleer1.playSong();
        System.out.println("-----------------");

        PleerTwo pleer2 = new PleerTwo(143, "Вторая песня");
        pleer2.playSong();
        System.out.println("-----------------");

        PleerThree pleer3 = new PleerThree(466, new String[]{"Песня 1", "Песня 2", "Песня 3", "Песня 4", "Песня 5", "Песня 6"});
        pleer3.playSong();
        System.out.println("-----------------");
        pleer3.playAllSongs();
        System.out.println("-----------------");

        PleerFour pleer4 = new PleerFour(135, new String[]{"Песня 1", "Песня 2", "Песня 3", "Песня 4", "Песня 5", "Песня 6"});
        pleer4.playSong();
        System.out.println("-----------------");
        pleer4.playAllSongs();
        System.out.println("-----------------");

        PleerFive pleer5 = new PleerFive(123, new String[]{"Песня 1", "Песня 2", "Песня 3", "Песня 4", "Песня 5", "Песня 6"});
        pleer5.playSong();
        System.out.println("-----------------");
        pleer5.playAllSongs();
        System.out.println("-----------------");

        PleerSix pleer6 = new PleerSix(796, new String[]{"Песня 1", "Песня 2", "Песня 3", "Песня 4", "Песня 5", "Песня 6"});
        pleer6.playSong();
        System.out.println("-----------------");
        pleer6.shuffle();
        pleer6.playAllSongs();
        System.out.println("-----------------");
    }
}
