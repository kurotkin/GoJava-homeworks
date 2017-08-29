package com.kurotkin;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
	    Fruit[] fruits = new Fruit[] {
	            new Fruit(Fruit.Type.Apple,     30, new Date(), 80),
                new Fruit(Fruit.Type.Carambola, 10, new Date(), 250),
                new Fruit(Fruit.Type.Lemon,     80, new Date(), 50),
                new Fruit(Fruit.Type.Mandarin,  60, new Date(), 80),
                new Fruit(Fruit.Type.Pythaghia, 5, new Date(), 180),
                new Fruit(Fruit.Type.Pomelo,    30, new Date(), 40),
                new Fruit(Fruit.Type.Cherimoya, 30, new Date(), 40),
                new Fruit(Fruit.Type.Kiwi,      30, new Date(), 40),
                new Fruit(Fruit.Type.Orange,    30, new Date(), 40),
        };
	    Shop shop = new Shop(new ArrayList<Fruit>(Arrays.asList(fruits)));
        shop.save("data.txt");
        shop.info();
        shop.addFruits("data.txt");
        shop.addFruits("data.txt");
        shop.info();
        LocalDate christmas = LocalDate.of(2014, Month.DECEMBER, 25);
        shop.info(shop.getSpoiledFruits(LocalDate.of(2017, Month.NOVEMBER, 25)));
    }
}
