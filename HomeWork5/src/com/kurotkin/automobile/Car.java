package com.kurotkin.automobile;

import java.util.Date;

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
    private CarDoor[] carDoors;
    private CarWheel[] carWheels;

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


}