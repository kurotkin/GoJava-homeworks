package com.kurotkin;

import com.kurotkin.flowers.Flower;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FlowerStore shop = new FlowerStore();
        List<Flower> l1 = shop.sel(1,2,3);
        FlowerStore.printFlowers(l1);

        List<Flower> l2 = shop.sel(3,3,3);
        FlowerStore.printFlowers(l2);

        List<Flower> l3 = shop.sel(2,2,2);
        FlowerStore.printFlowers(l3);

        List<Flower> l4 = shop.sel(1,0,0);
        FlowerStore.printFlowers(l4);

        List<Flower> l5 = shop.sellSequence(8,4,1);
        FlowerStore.printFlowers(l5);

        List<Flower> l6 = shop.sellSequence(0,2,4);
        FlowerStore.printFlowers(l6);

        List<Flower> l7 = shop.sellSequence(7,5,6);
        FlowersSaver.save(l7, "bouquet.txt");
        System.out.print("Загружено: ");
        List<Flower> l8 = FlowersLoader.load("bouquet.txt");
        FlowerStore.printFlowers(l8);

        System.out.println("----------------------");
        System.out.println("Выручка магазина: " + shop.getPurseInfo());
    }
}
