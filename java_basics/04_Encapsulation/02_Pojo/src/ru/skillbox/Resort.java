package ru.skillbox;

public class Resort {
    private String name;
    private float area;
    private int stars;
    private boolean isAllInclusive;
    private float distanceToWater;

    public Resort(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isAllInclusive() {
        return isAllInclusive;
    }

    public void setAllInclusive(boolean allInclusive) {
        isAllInclusive = allInclusive;
    }

    public float getDistanceToWater() {
        return distanceToWater;
    }

    public void setDistanceToWater(float distanceToWater) {
        this.distanceToWater = distanceToWater;
    }
}
