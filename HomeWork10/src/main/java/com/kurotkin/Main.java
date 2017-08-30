package com.kurotkin;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
	    Fruit[] fruits = new Fruit[] {
	            new Fruit(Fruit.Type.Apple,     30, LocalDate.now(), 80),
                new Fruit(Fruit.Type.Carambola, 10, LocalDate.now(), 250),
                new Fruit(Fruit.Type.Lemon,     80, LocalDate.now(), 50),
                new Fruit(Fruit.Type.Mandarin,  60, LocalDate.now(), 80),
                new Fruit(Fruit.Type.Pythaghia, 5,  LocalDate.now(), 180),
                new Fruit(Fruit.Type.Pomelo,    30, LocalDate.now(), 40),
                new Fruit(Fruit.Type.Cherimoya, 30, LocalDate.now(), 40),
                new Fruit(Fruit.Type.Kiwi,      30, LocalDate.now(), 40),
                new Fruit(Fruit.Type.Orange,    30, LocalDate.now(), 40),
        };
	    Shop shop = new Shop(new ArrayList<Fruit>(Arrays.asList(fruits)));
        shop.save("data.txt");
        shop.info();
        shop.addFruits("data.txt");
        shop.addFruits("data.txt");
        shop.info();

        LocalDate spoiledDate = LocalDate.of(2017, Month.SEPTEMBER, 15);
        System.out.println();
        System.out.println("Испорченные продукты к " + spoiledDate);
        shop.info(shop.getSpoiledFruits(spoiledDate));

        System.out.println();
        System.out.println("Готовые к продаже продукты на " + spoiledDate);
        shop.info(shop.getAvailableFruits(spoiledDate));

        System.out.println();
        System.out.println("Испорченая патайа на " + spoiledDate);
        shop.info(shop.getSpoiledFruits(spoiledDate, Fruit.Type.Pythaghia));

        System.out.println();
        System.out.println("Готовые к продаже яблоки на " + spoiledDate);
        shop.info(shop.getAvailableFruits(spoiledDate, Fruit.Type.Apple));

        LocalDate date = LocalDate.now();
        System.out.println();
        System.out.println("Добавленные фрукты на " + date);
        shop.info(shop.getAddedFruits(date));

        System.out.println();
        System.out.println("Добавленные киви на " + date);
        shop.info(shop.getAddedFruits(date, Fruit.Type.Kiwi));
    }
}
