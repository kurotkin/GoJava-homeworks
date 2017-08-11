package com.kurotkin;

import com.kurotkin.flowers.Flower;
import com.kurotkin.flowers.FlowerStore;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flower> l1 = FlowerStore.sel(1,2,3);
        FlowerStore.printFlowers(l1);

        List<Flower> l2 = FlowerStore.sel(3,3,3);
        FlowerStore.printFlowers(l2);

        List<Flower> l3 = FlowerStore.sel(2,2,2);
        FlowerStore.printFlowers(l3);

        List<Flower> l4 = FlowerStore.sel(1,0,0);
        FlowerStore.printFlowers(l4);

        List<Flower> l5 = FlowerStore.sellSequence(8,4,1);
        FlowerStore.printFlowers(l5);

        List<Flower> l6 = FlowerStore.sellSequence(0,2,4);
        FlowerStore.printFlowers(l6);

        List<Flower> l7 = FlowerStore.sellSequence(3,3,3);
        FlowerStore.printFlowers(l7);
    }
}
