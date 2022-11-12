package ru.skillbox;

public class Main {
    public static void main(String[] args){

        Basket vasyaBasket = new Basket();
        vasyaBasket.add("Молоко", 80);
        vasyaBasket.add("Хлеб",40);

        Basket mashaBasket = new Basket("Стол", 5000);

        Basket petyaBasket = new Basket(500);
        petyaBasket.add("Лопата",280);
        petyaBasket.add("Бочка",2900);

        vasyaBasket.print("Корзина Васи: ");
        petyaBasket.print("Корзина Пети: ");
        mashaBasket.print("Корзина Маши");

        System.out.println();
        System.out.println("Общая стоимость всех корзин: " + Basket.getTotalPriceAll());
        System.out.println("Общее кол-во товаров во всех корзинах: " + Basket.getTotalItemsAll());
        System.out.println("Средняя стоимость товаров по всем карзинам: " + Basket.getMiddlePrice());
        System.out.println("Средняя стоимость корзины: " + Basket.getMiddlePriceOnBasket());
    }
}
