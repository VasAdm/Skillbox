import java.util.*;
import java.util.stream.Collectors;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalArgumentException, AuxiliaryException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final String regexName = "[а-яА-Я]+\\s[а-яА-Я]+";
        final String regexEmail = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,3}";
        final String regexPhone = "\\+[7][0-9]{10}";

        String[] components = data.split("\\s+");
        if (components.length != 4) throw new IllegalArgumentException("Wrong format");

        if (!components[2].matches(regexEmail)) throw new IllegalArgumentException("Wrong E-mail");

        if (!components[3].matches(regexPhone)) throw new IllegalArgumentException("Wrong Phone number");

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        name = beautifierForNames(name);

        if (!name.matches(regexName)) throw new AuxiliaryException("Имя и фамилия должны быть на русском языке", name);

        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private String beautifierForNames (String name) {
        return Arrays.stream(name.split(" "))
                .map(s -> s.substring(0,1).toUpperCase(Locale.ROOT) + s.substring(1).toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(" "));
    }
}