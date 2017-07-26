package com.kurotkin.automobile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Vitaly on 24.07.17.
 */
public class Car {
    private String dateOfProduction;
    private String typeEngine;
    private double maxSpeed;
    private double accelerationTime;
    private int passengerCapacity;
    private int numberPassenger;
    private double currentSpeed;
    private List<CarDoor> carDoors = new ArrayList<>();
    public List<CarWheel> carWheels = new ArrayList<>();

    public Car(String dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public Car(String dateOfProduction,
               String typeEngine,
               double maxSpeed,
               double accelerationTime,
               int passengerCapacity,
               int numberPassenger,
               double currentSpeed) {
        if (maxSpeed < 0.0)
            throw new IllegalArgumentException("Отрицательная максимальная скорость");
        if (accelerationTime < 0.0)
            throw new IllegalArgumentException("Отрицательное время разгона до 100км/ч");
        if (passengerCapacity < 0.0)
            throw new IllegalArgumentException("Отрицательная пассажировместимость");
        if (numberPassenger < 0.0)
            throw new IllegalArgumentException("Отрицательная количество пассажиров");
        if (numberPassenger > passengerCapacity)
            throw new IllegalArgumentException("Количество пассижиров больше, чем вмещается");
        if (currentSpeed < 0.0)
            throw new IllegalArgumentException("Отрицательная текущая скорость");
        this.dateOfProduction = dateOfProduction;
        this.typeEngine = typeEngine;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.passengerCapacity = passengerCapacity;
        this.numberPassenger = numberPassenger;
        this.currentSpeed = currentSpeed;
    }

    public void changeSpeed(double ps) {
        if (ps < 0.0 || ps > 100.0)
            throw new IllegalArgumentException("Ошибка, изменение скорости должно быть 0..100.0% По факту " + ps);
        else {
            currentSpeed += (currentSpeed / 100.0 * ps);
            if (currentSpeed > maxSpeed)
                currentSpeed = maxSpeed;
        }
    }

    public void putPassenger() {
        numberPassenger++;
        if (numberPassenger > passengerCapacity)
            numberPassenger = passengerCapacity;
    }

    public void disPutPassenger() {
        numberPassenger--;
        if (numberPassenger < 0)
            numberPassenger = 0;
    }

    public void disPutAllPassenger() {
        numberPassenger = 0;
    }

    public CarDoor getDoor (int index) {
        return carDoors.get(index);
    }

    public CarWheel getWheel (int index) {
        return carWheels.get(index);
    }

    public void removeAllWheels(){
        carWheels.clear();
    }

    public void installWheels(int number){
        if (number < 0) throw new IllegalArgumentException("Ошибка, добавлять можно только целое количество колес");
        while (number > 0) {
            carWheels.add(new CarWheel());
            number--;
        }
    }


    public double getCurrentMaxSpeed(){
        if(numberPassenger == 0)
            return 0;
        return carWheels.stream().min(Comparator.comparing(wheel -> wheel.state())).get().state() * maxSpeed;
    }

    public void info() {
        System.out.println("Дата производства " + dateOfProduction);
        System.out.println("Тип двигателя " + typeEngine);
        System.out.println("Максимальная скорость " + getCurrentMaxSpeed());
        System.out.println("Пассажировместимость " + passengerCapacity);
    }
}