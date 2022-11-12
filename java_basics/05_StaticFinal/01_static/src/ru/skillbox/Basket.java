package ru.skillbox;

public class Basket {
    private static int count = 0;
    private static int totalPriceAll = 0;
    private static int totalItemsAll = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        items = "\nСписок товаров:";
        this.limit = 10000000;
        increaseCount();
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + "\n" + items + " - 1  шт. - " + totalPrice;
        this.totalPrice = totalPrice;
        increaseTotalPriceAll(totalPrice);
        increaseTotalItemsAll(1);
    }

    public static void increaseTotalItemsAll(int count) {
        Basket.totalItemsAll = Basket.totalItemsAll + count;
    }

    public static void increaseTotalPriceAll(int price) {
        Basket.totalPriceAll = Basket.totalPriceAll + price;
    }

    public static void increaseCount() {
        Basket.count = Basket.count + 1;
    }

    public static double getTotalItemsAll() {
        return totalItemsAll;
    }

    public static double getTotalPriceAll() {
        return totalPriceAll;
    }

    public static int getTotalBaskets() {
        return count;
    }

    public static double getMiddlePrice() {
        return Basket.getTotalPriceAll() / Basket.getTotalItemsAll();
    }

    public static double getMiddlePriceOnBasket() {
        return Basket.getTotalPriceAll() / Basket.getTotalBaskets();
    }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = contains(name);

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight;
        increaseTotalItemsAll(count);
        increaseTotalPriceAll(count * price);
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.print(title);
        if (items.isEmpty()) System.out.println("\nКорзина пуста");
        else System.out.println(items + "\n=========================");
    }
}
