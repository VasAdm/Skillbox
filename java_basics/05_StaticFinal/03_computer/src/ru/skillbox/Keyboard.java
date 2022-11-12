package ru.skillbox;

public class Keyboard {
    private final KeyboardType type;
    private final boolean illumination;
    private final int weight;

    public Keyboard(KeyboardType type, boolean illumination, int weight) {
        this.type = type;
        this.illumination = illumination;
        this.weight = weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public boolean isIllumination() {
        return illumination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return  "Тип клавиатуры: " + getType() +
                ", наличие подсветки: " + (isIllumination() ? "Да" : "Нет") +
                ", вес: " + getWeight() + " гр";
    }
}
