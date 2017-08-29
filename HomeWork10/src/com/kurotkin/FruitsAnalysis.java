package com.kurotkin;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by Андрей on 29.08.2017.
 */
public interface FruitsAnalysis {
    List<Fruit> getSpoiledFruits(LocalDate date);
    List<Fruit> getAvailableFruits(Date date);
}
