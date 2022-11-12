public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());
        System.out.println("====" + System.lineSeparator());

        First first = new First();
        Second second = new Second();

        first.alphabetFirst();
        second.alphabetSecond();

    }
}
