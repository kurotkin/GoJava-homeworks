package com.kurotkin;

import com.kurotkin.flowers.Flower;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Vitaly Kurotkin on 14.08.2017.
 */
public class FlowersSaver {
    public static void save(List<Flower> flowers, String fileName){
        try(FileWriter writer = new FileWriter(fileName, false)) {
            for (Flower f : flowers) {
                writer.write(f.getClass().getSimpleName() + " ");
            }
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
