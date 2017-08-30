package com.kurotkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        info(fruitList);
    }

    public void info(List<Fruit> fruits) {
        System.out.println("-----------------------");
        System.out.println("Тип     Срок годности     Дата производства       Цена ");
        for (Fruit fruit : fruits){
            System.out.print(fruit.getKind());
            int i = fruit.getKind().toString().length();
            while (i < 10) {
                System.out.print(" ");
                i++;
            }
            System.out.print("     ");
            System.out.print(fruit.getShelfLife());
            if (fruit.getShelfLife() < 10)
                System.out.print(" ");
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
            int daysBetween = (int) ChronoUnit.DAYS.between(fruit.dateOfDelivery, date);
            if (daysBetween > fruit.getShelfLife()){
                spoiledFruits.add(fruit);
            }
        }
        return spoiledFruits;
    }

    @Override
    public List<Fruit> getAvailableFruits(LocalDate date) {
        return fruitList.stream()
                .filter((fruit) -> ChronoUnit.DAYS.between(fruit.dateOfDelivery, date) < fruit.getShelfLife())
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getSpoiledFruits(LocalDate date, Fruit.Type type) {
        return getSpoiledFruits(date).stream()
                .filter((fruit) -> fruit.getKind().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAvailableFruits(LocalDate date, Fruit.Type type) {
        return getAvailableFruits(date).stream()
                .filter((fruit) -> fruit.getKind().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAddedFruits(LocalDate date) {
        return fruitList.stream()
                .filter((fruit) -> fruit.dateOfDelivery.equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fruit> getAddedFruits(LocalDate date, Fruit.Type type) {
        return getAddedFruits(date).stream()
                .filter((fruit) -> fruit.getKind().equals(type))
                .collect(Collectors.toList());
    }


}
