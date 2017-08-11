package com.kurotkin.flowers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly Kurotkin on 11.08.2017.
 */
public class FlowerStore {

    public static void printFlowers(List<Flower> bouquet){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < bouquet.size(); i++){
            if (bouquet.get(i) instanceof Rose)
                str.append("роза, ");
            if (bouquet.get(i) instanceof Chamomile)
                str.append("ромашка, ");
            if (bouquet.get(i) instanceof Tulip)
                str.append("тюльпан, ");
        }
        System.out.println(str.substring(0, str.length() - 2));
    }

    public static List<Flower> sel(int numRose, int numChamomile, int numTulip) {
        ArrayList<Flower> bouquet = new ArrayList<>();
            while(numRose > 0){
                bouquet.add(new Rose());
                numRose--;
            }
            while(numChamomile > 0){
                bouquet.add(new Chamomile());
                numChamomile--;
            }
            while(numTulip-- > 0){
                bouquet.add(new Tulip());
                numTulip--;
            }
        return bouquet;
    }

    public static List<Flower> sellSequence (int numRose, int numChamomile, int numTulip) {
        ArrayList<Flower> bouquet = new ArrayList<>();
        while(numRose > 0 || numChamomile > 0 || numTulip > 0){
            if (numRose > 0) {
                bouquet.add(new Rose());
                numRose --;
            }
            if (numChamomile > 0) {
                bouquet.add(new Chamomile());
                numChamomile --;
            }
            if (numTulip > 0) {
                bouquet.add(new Tulip());
                numTulip --;
            }
        }
        return bouquet;
    }
}
