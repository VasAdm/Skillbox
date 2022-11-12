public class Main {
    public static void main(String[] args) {
        Client client = new PhysicalPerson();
        client.put(300.0);
        System.out.println(client.getAmount());
    }
}
