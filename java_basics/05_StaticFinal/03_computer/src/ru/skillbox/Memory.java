package ru.skillbox;

public class Memory {
    private final DdrType type;
    private final int size;
    private final int weight;

    public Memory(DdrType type, int size, int weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public DdrType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "Тип: " + getType() +
                ", объем памяти: " + getSize() + " МБ" +
                ", вес: " + getWeight() + " гр";
    }
}
