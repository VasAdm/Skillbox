public class Second {
    public void alphabetSecond() {
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] alphabetArray = alphabet.toCharArray();

        for (char c : alphabetArray) {
            System.out.println(c + ": " + (int) c);
        }
    }
}