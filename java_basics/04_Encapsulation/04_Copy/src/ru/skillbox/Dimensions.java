package ru.skillbox;

public class Dimensions {
    private final float width;
    private final float height;
    private final float length;

    public Dimensions(float width, float height, float length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public Dimensions setWidth(float width) {
        return new Dimensions(width, height, length);
    }

    public float getHeight() {
        return height;
    }

    public Dimensions setHeight(float height) {
        return new Dimensions(width, height, length);
    }

    public float getLength() {
        return length;
    }

    public Dimensions setLength(float length) {
        return new Dimensions(width, height, length);
    }

    public float amount(){
        return (getWidth() * getHeight() * getLength());
    }
}