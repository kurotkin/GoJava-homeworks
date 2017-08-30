package com.kurotkin;

import java.io.IOException;

/**
 * Created by Vitaly Kurotkin on 28.08.2017.
 */
public interface FruitsSupplies {
    void addFruits(String pathToJsonFile) throws IOException;
    void save(String pathToJsonFile) throws IOException;
    void load(String pathToJsonFile) throws IOException;
}
