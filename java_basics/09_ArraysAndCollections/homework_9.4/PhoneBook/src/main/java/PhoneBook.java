import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    HashMap<String, String> phoneMap = new HashMap<>();
    String regexName = "[А-Яа-яA-Za-z]+";
    String regexPhone = "[7,8][9][0-9]{9}";


    public enum PhoneOrNum {
        LIST,PHONE,NAME,UNDEFINED
    }

    public Enum<PhoneOrNum> checkInput(String str) {
        if (str.equals("LIST")) {
            return PhoneOrNum.LIST;
        } else if (str.matches(regexName)) {
            return PhoneOrNum.NAME;
        } else if (str.matches(regexPhone)) {
            return PhoneOrNum.PHONE;
        } else return PhoneOrNum.UNDEFINED;
    }

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента

        if (phone.matches(regexPhone) && name.matches(regexName)) {
            phoneMap.put(phone, name);
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку

        if (phoneMap.containsKey(phone)) {
            return phoneMap.get(phone) + " - " + phone;
        } else return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

        TreeSet<String> pBN = new TreeSet<>();
        if (phoneMap.containsValue(name)) {
            for (String record : phoneMap.keySet()) {
                if (phoneMap.get(record).equals(name)) pBN.add(phoneMap.get(record) + " - " + record);
            }
        }
        return pBN;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet

        TreeSet<String> contacts = new TreeSet<>();
        if (phoneMap.isEmpty()) {
            return contacts;
        } else {
            for (String record : phoneMap.keySet()) {
                contacts.add(phoneMap.get(record) + " - " + record);
            }
            return contacts;
        }
    }
}