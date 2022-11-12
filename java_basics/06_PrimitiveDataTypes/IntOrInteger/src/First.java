public class First {
    public void alphabetFirst() {
        System.out.println("Заглавные");
        for (char i = 'А'; i <= 'Е'; i++) {
            int z = i;
            System.out.println(i + " - " + z);
        }
        char n = 'Ё';
        int z1 = n;
        System.out.println(n + " - " + z1);
        for (char t = 'Ж'; t <= 'Я'; t++) {
            int z2 = t;
            System.out.println(t + " - " + z2);
        }

        System.out.println("Строчные");
        for (char j = 'а'; j <= 'е'; j++) {
            int s = j;
            System.out.println(j + " - " + s);
        }
        char m = 'ё';
        int s1 = m;
        System.out.println(m + " - " + s1);
        for (char l = 'ж'; l <= 'я'; l++) {
            int s2 = l;
            System.out.println(l + " - " + s2);
        }

    }
}
