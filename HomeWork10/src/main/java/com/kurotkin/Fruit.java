package com.kurotkin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Vitaly Kurotkin on 28.08.2017.
 */
public class Fruit {
    private Type kind;
    private int shelfLife;
    public LocalDate dateOfDelivery;
    private int price;

    public enum Type {
        Apricot, Avocado, Aiva, Alycha, Pineapple, Orange, Banana, Bergamot,
        Pomegranate, Grapefruit, Pear, Guava, Jackfruit, Pythaghia, Durian,
        Carambola, Kiwi, Clementine, Kumquat, Lime, Lemon, Lychee, Longan,
        Mango, Mangosteen, Mandarin, Maracuya, Mushmula, Nectarine, Papaya,
        Peach, Pomelo, Pomeranets, Rambutan, Salak, Sapodilla, Sweetie, Plum,
        Tangelo, Henomesel, Persimmon, Citron, Cherimoya, Chompu, Apple
    };

    public Fruit(Type kind, int shelfLife, LocalDate dateOfDelivery, int price) throws Exception {
        this.kind = kind;
        setShelfLife(shelfLife);
        this.dateOfDelivery = dateOfDelivery;
        setPrice(price);
    }


    public Fruit() {
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) throws Exception {
        if(shelfLife < 0)
            throw new Exception("shelfLife < 0");
        this.shelfLife = shelfLife;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws Exception {
        if (price < 0)
            throw new Exception("price < 0");
        this.price = price;
    }

    public Type getKind() {
        return kind;
    }

    public void setKind(Type kind) {
        this.kind = kind;
    }
}
