package com.kurotkin.automobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vitaly on 24.07.17.
 */
public class Car {
    private Date dateOfProduction;
    private String typeEngine;
    private double maxSpeed;
    private double accelerationTime;
    private int passengerCapacity;
    private int numberPassenger;
    private double currentSpeed;
    private List<CarDoor> carDoors = new ArrayList<>();
    private List<CarWheel> carWheels = new ArrayList<>();

    public Car(Date dateOfProduction) {
        if (dateOfProduction.after(new Date()))
            throw new IllegalArgumentException("Дата выпуска автомобиля из будущего");
        this.dateOfProduction = dateOfProduction;
    }

    public Car(Date dateOfProduction,
               String typeEngine,
               double maxSpeed,
               double accelerationTime,
               int passengerCapacity,
               int numberPassenger,
               double currentSpeed) {
        if (dateOfProduction.after(new Date()))
            throw new IllegalArgumentException("Дата выпуска автомобиля из будущего");
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



//    Установить на машину X новых колесу (в добаков к имеющимся, то есть если было 4 колеса, после вызова метода с Х аргументом равным трем, колес будет 4+3=7)
//    Вычислить текущую возможную максимальную скорость (Скорость машины вычисляется так. Максимальная скорость новой машины множиться на самое стертое колесо в машине. Максимальная скорость равна 0 если в машине нет ни одного пассажира, так как некому ее вести)
//    Вывести в консоль данные об объекте (все поля и вычисленную максимальную скорость в зависимости от целостности колес и наличия водителя)
//
//
//    Install the new wheel on the machine X (in addition to the existing ones, that is, if there were 4 wheels, after calling the method with X argument equal to three, the wheel will be 4 + 3 = 7)
//    Calculate the current maximum speed possible (The speed of the machine is calculated as follows: the maximum speed of the new machine is multiplied by the most worn out wheel in the car.) The maximum speed is 0 if there is not one passenger in the car, since there is no one to drive it)
//    Output to the console information about the object (all fields and the calculated maximum speed, depending on the integrity of the wheels and the presence of the driver)

}