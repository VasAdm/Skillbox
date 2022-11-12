package ru.skillbox;

public class Drive {
    private final double size;
    private final double weight;

    public Drive(double size, double weight) {
        this.size = size;
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "Объем диска: " + getSize() + " МБ" +
                ", вес: " + getWeight() + " гр";
    }
}
