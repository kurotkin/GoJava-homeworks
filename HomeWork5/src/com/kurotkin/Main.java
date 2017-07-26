package com.kurotkin;

import com.kurotkin.automobile.Car;
import com.kurotkin.automobile.CarWheel;

public class Main {

    public static void main(String[] args) {
        Car myCar = new Car("2008", "A1", 200, 5, 5, 3, 75.4);
        myCar.installWheels(4);
        int number = 1;
        CarWheel badWheel =  myCar.carWheels.get(number);
        badWheel.erase(50);
        myCar.carWheels.set(number, badWheel);
        myCar.info();
    }
}
