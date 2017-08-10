package com.kurotkin.automobile;

/**
 * Created by Vitaly on 24.07.17.
 */
public class CarDoor {
    private boolean doorIsOpen;
    private Window window;

    public CarDoor() {
        doorIsOpen = false;
        window = new Window();
    }

    public CarDoor(boolean doorIsOpen, boolean windowIsOpen) {
        this.doorIsOpen = doorIsOpen;
        window = new Window(windowIsOpen);
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


    public void info() {
        if (doorIsOpen)
            System.out.println("Дверь открыта");
        else
            System.out.println("Дверь закрыта");
        window.info();
    }

    /*
    * Добавлено 10.08.2017
    **/
    private class Window {
        private boolean windowIsOpen;
        public Window() {
            windowIsOpen = false;
        }

        public Window(boolean windowIsOpen) {
            this.windowIsOpen = windowIsOpen;
        }

        public void closeWindow() {
            windowIsOpen = false;
        }

        public void openWindow() {
            windowIsOpen = true;
        }

        public void info() {
            if (windowIsOpen)
                System.out.println("Окно открыто");
            else
                System.out.println("Окно закрыто");
        }

        public void opClWindow() {
            windowIsOpen = !windowIsOpen;
        }
    }

}
