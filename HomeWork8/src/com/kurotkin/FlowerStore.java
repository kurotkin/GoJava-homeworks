package com.kurotkin;

import com.kurotkin.flowers.Chamomile;
import com.kurotkin.flowers.Flower;
import com.kurotkin.flowers.Rose;
import com.kurotkin.flowers.Tulip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaly Kurotkin on 11.08.2017.
 */
public class FlowerStore {
    private int purse = 0;

    public List<Flower> sel(int numRose, int numChamomile, int numTulip) {
        ArrayList<Flower> bouquet = new ArrayList<>();
            while(numRose > 0){
                Flower rose = new Rose();
                bouquet.add(rose);
                numRose--;
                purse += rose.getPrice();
            }
            while(numChamomile > 0){
                Flower chamomile = new Chamomile();
                bouquet.add(new Chamomile());
                numChamomile--;
                purse += chamomile.getPrice();
            }
            while(numTulip-- > 0){
                Flower tulip = new Tulip();
                bouquet.add(new Tulip());
                numTulip--;
                purse += tulip.getPrice();
            }
        return bouquet;
    }

    public List<Flower> sellSequence (int numRose, int numChamomile, int numTulip) {
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

    public int getPurseInfo() {
        return purse;
    }

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
}
