package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(3,2,5);
        Cargo cargo = new Cargo(dimensions, 100, "Магнитогорск", true, "5553377", false);
        System.out.println(cargo);
        Cargo copy = cargo.setDeliveryAddress("Челябинск");
        System.out.println(copy);
    }
}
