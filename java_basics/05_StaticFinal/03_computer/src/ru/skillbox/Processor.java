package ru.skillbox;

public class Processor {
    private final int frequency; //Mhz
    private final int numberOfCore;
    private final String manufacturer;
    private final int weight; //gr

    public Processor(int frequency, int numberOfCore, String manufacturer, int weight) {
        this.frequency = frequency;
        this.numberOfCore = numberOfCore;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getNumberOfCore() {
        return numberOfCore;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "Частота:" + getFrequency() + " Mhz" +
                ", колличество ядер:" + getNumberOfCore() +
                ", производитель:'" + getManufacturer() + '\'' +
                ", вес:" + getWeight() + " гр";
    }
}
