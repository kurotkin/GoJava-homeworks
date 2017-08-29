package com.kurotkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * Created by Vitaly Kurotkin on 28.08.2017.
 */
public class Shop implements FruitsSupplies, FruitsAnalysis {

    private List<Fruit> fruitList;

    public Shop(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    @Override
    public void addFruits(String pathToJsonFile) throws IOException {
        // https://github.com/alibaba/fastjson
        BufferedReader reader = new BufferedReader(new FileReader(pathToJsonFile));
        String json = reader.readLine();
        List<Fruit> fruits = JSON.parseArray(json, Fruit.class);
        fruitList.addAll(fruits);
    }

    @Override
    public void save(String pathToJsonFile) throws IOException {
        String jsonString = JSON.toJSONString(fruitList);
        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(jsonString);
        writer.flush();
        writer.close();
    }

    @Override
    public void load(String pathToJsonFile) throws IOException {
        fruitList.clear();
        addFruits(pathToJsonFile);
    }

    public void info() {
        System.out.println("-----------------------");
        System.out.println("Тип    Срок годности     Дата производства     Цена ");
        for (Fruit fruit : fruitList){
            System.out.print(fruit.getKind());
            System.out.print("     ");
            System.out.print(fruit.getShelfLife());
            System.out.print("            ");
            System.out.print(fruit.getDateOfDelivery());
            System.out.print("             ");
            System.out.println(fruit.getPrice());
        }
        System.out.println("-----------------------");
    }

    public void info(List<Fruit> fruits) {
        System.out.println("-----------------------");
        System.out.println("Тип    Срок годности     Дата производства     Цена ");
        for (Fruit fruit : fruits){
            System.out.print(fruit.getKind());
            System.out.print("     ");
            System.out.print(fruit.getShelfLife());
            System.out.print("            ");
            System.out.print(fruit.getDateOfDelivery());
            System.out.print("             ");
            System.out.println(fruit.getPrice());
        }
        System.out.println("-----------------------");
    }

    @Override
    public List<Fruit> getSpoiledFruits(LocalDate date) {
        List<Fruit> spoiledFruits = new ArrayList<>();
        for(Fruit fruit : fruitList){
            LocalDate date2 = fruit.dateOfDelivery.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int daysBetween = (int) ChronoUnit.DAYS.between(date2, date);

            if (daysBetween > fruit.getShelfLife())
                spoiledFruits.add(fruit);
        }
        return spoiledFruits;
    }

    @Override
    public List<Fruit> getAvailableFruits(Date date) {
        return null;
    }


}
