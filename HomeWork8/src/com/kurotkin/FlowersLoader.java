package com.kurotkin;

import com.kurotkin.flowers.Chamomile;
import com.kurotkin.flowers.Flower;
import com.kurotkin.flowers.Rose;
import com.kurotkin.flowers.Tulip;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Vitaly Kurotkin on 14.08.2017.
 */
public class FlowersLoader {
    public static List<Flower> load (String fileName){
        List<Flower> flowers = new ArrayList<>();

        try(Scanner sc = new Scanner(new File(fileName))) {
            String[] arrayString = sc.nextLine().split(" ");
            for(String s : arrayString){
                if(s.equals(Rose.class.getSimpleName()))
                    flowers.add(new Rose());
                if(s.equals(Chamomile.class.getSimpleName()))
                    flowers.add(new Chamomile());
                if(s.equals(Tulip.class.getSimpleName()))
                    flowers.add(new Tulip());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flowers;
    }
}
