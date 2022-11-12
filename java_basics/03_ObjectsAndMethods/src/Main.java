public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Milk");
        System.out.println("===========================");

        Printer printer = new Printer();
        printer.append("Hello world", "Hello", 7);
        printer.append("Second text", "Second");
        printer.append("Third text");
        printer.print();
        System.out.println("Всего распечатано: " + printer.getAllPagesCount() + " страниц");
        System.out.println("===========================");
    }
}
