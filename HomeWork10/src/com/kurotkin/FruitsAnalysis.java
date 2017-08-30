package com.kurotkin;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Андрей on 29.08.2017.
 */
public interface FruitsAnalysis {
    List<Fruit> getSpoiledFruits(LocalDate date);
    List<Fruit> getSpoiledFruits(LocalDate date, Fruit.Type type);
    List<Fruit> getAvailableFruits(LocalDate date);
    List<Fruit> getAvailableFruits(LocalDate date, Fruit.Type type);
    List<Fruit> getAddedFruits(LocalDate date);
    List<Fruit> getAddedFruits(LocalDate date, Fruit.Type type);
}
