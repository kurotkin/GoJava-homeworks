package com.kurotkin.automobile;

/**
 * Created by Vitaly on 24.07.17.
 */
public class CarWheel {
    private double condition;

    public CarWheel () {
        condition = 1.0;
    }

    public CarWheel (double condition) {
        if (condition < 0.0 || condition > 1.0)
            throw new IllegalArgumentException("Ошибка, состояние шины должно быть 0..1 По факту " + condition);
        else
            this.condition = condition;
    }

    public void newWheel() {
        condition = 1.0;
    }

    public void erase(double ps) {
        if (ps < 0.0 || ps > 100.0)
            throw new IllegalArgumentException("Ошибка, износ шины должен быть 0..100.0  По факту " + ps);
        else
            condition -= (condition / 100.0 * ps);
    }

    public double state() {
        return condition;
    }

    public void info() {
        System.out.println("Состояние шины " + condition + "%");
    }
}
