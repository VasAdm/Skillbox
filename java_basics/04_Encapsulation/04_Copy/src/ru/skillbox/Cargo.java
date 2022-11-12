package ru.skillbox;

public class Cargo {
    private final Dimensions dimensions;
    private final float weight;
    private final String deliveryAddress;
    private final boolean isFlippable;
    private final String regNumber;
    private final boolean isFragile;

    public Cargo(Dimensions dimensions, float weight, String deliveryAddress, boolean isFlippable, String regNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.isFlippable = isFlippable;
        this.regNumber = regNumber;
        this.isFragile = isFragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress, isFlippable, regNumber, isFragile);
    }

    public float getWeight() {
        return weight;
    }

    public Cargo setWeight(float weight) {
        return new Cargo(dimensions, weight, deliveryAddress, isFlippable, regNumber, isFragile);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, isFlippable, regNumber, isFragile);
    }

    public boolean getIsFlippable() {
        return isFlippable;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public boolean getIsFragile() {
        return isFragile;
    }

    public String toString(){
        return
        "\tОбъем: " + getDimensions().amount() + System.lineSeparator() +
        "\tВес: " + getWeight() + System.lineSeparator() +
        "\tАдрес доставки: " + getDeliveryAddress() + System.lineSeparator() +
        "\tМожно переворачивать: " + getIsFlippable() + System.lineSeparator() +
        "\tРег. номер: " + getRegNumber() + System.lineSeparator() +
        "\tХрупкий груз: " + getIsFragile() + System.lineSeparator();
    }
}
