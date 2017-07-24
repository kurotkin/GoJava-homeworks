package com.kurotkin.automobile;

/**
 * Created by Vitaly on 24.07.17.
 */
public class CarDoor {
    private boolean doorIsOpen;
    private boolean windowIsOpen;

    public CarDoor() {
        doorIsOpen = false;
        windowIsOpen = false;
    }

    public CarDoor(boolean doorIsOpen, boolean windowIsOpen) {
        this.doorIsOpen = doorIsOpen;
        this.windowIsOpen = windowIsOpen;
    }

    public void closeDoor() {
        doorIsOpen = false;
    }

    public void openDoor() {
        doorIsOpen = true;
    }

    public void opClDoor() {
        doorIsOpen = !doorIsOpen;
    }

    public void closeWindow() {
        windowIsOpen = false;
    }

    public void openWindow() {
        windowIsOpen = true;
    }

    public void opClWindow() {
        windowIsOpen = !windowIsOpen;
    }

    public void info() {
        if (doorIsOpen)
            System.out.println("Дверь открыта");
        else
            System.out.println("Дверь закрыта");

        if (windowIsOpen)
            System.out.println("Окно открыто");
        else
            System.out.println("Окно закрыто");
    }

}
