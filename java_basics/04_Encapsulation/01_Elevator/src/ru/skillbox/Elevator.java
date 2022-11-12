package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int min, int max) {
        minFloor = min;
        maxFloor = max;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void moveDown(){
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }
    public void moveUp(){
        currentFloor = currentFloor < maxFloor ? currentFloor + 1 : currentFloor;
    }

    public void move(int floor){
        if (floor > maxFloor || floor < minFloor){
            System.out.println("Ошибка! В здании нет такого этажа.");
        } else {
            if (floor > currentFloor) {
                for (int i = currentFloor; i < floor; i++) {
                    moveUp();
                    System.out.println(getCurrentFloor() + " этаж.");
                }
            } else if (floor < currentFloor) {
                for (int i = currentFloor; i > floor; i--) {
                    moveDown();
                    System.out.println(getCurrentFloor() + " этаж.");
                }
            } else System.out.println(getCurrentFloor() + " этаж.");


        }
    }
}
