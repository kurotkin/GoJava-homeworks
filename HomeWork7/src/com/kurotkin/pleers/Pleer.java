package com.kurotkin.pleers;

/**
 * Created by Kurotkin Vitaly on 02.08.2017.
 */
public abstract class Pleer {
    private final int price;
    protected String[] playlist;
    protected String pleerName;

    public Pleer(int price) {
        this.price = price;
    }

    protected void playSong(int idSong) {
        try {
            System.out.println("Playing: " + playlist[idSong]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет такой песни");
        }
    }

    public void playSong() {
        System.out.println(pleerName);
        playSong(0);
    }

    public int getPrice() {
        return price;
    }
}
