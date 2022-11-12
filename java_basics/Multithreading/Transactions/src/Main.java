import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        List<Thread> threadsAdd = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            threadsAdd.add(new Thread(Main::taskCreateAcc));
        }
        threadsAdd.forEach(Thread::start);

         try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(Main::taskTransactions));
        }
        threads.forEach(Thread::start);
    }

    private static long randomLong() {
        long leftLimit = 0L;
        long rightLimit = 52631L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    private static void taskCreateAcc() {
        synchronized (Account.class) {
            Account acc = new Account();
            acc.setMoney(randomLong());
            bank.addAccount(acc.getAccNumber(), acc);
        }

    }

    private static void taskTransactions() {
        List<Long> keysAsArray = new ArrayList<>(bank.getAccounts().keySet());
        Random r = new Random();
        Long src = keysAsArray.get(r.nextInt(keysAsArray.size()));
        Long dst = keysAsArray.get(r.nextInt(keysAsArray.size()));

        bank.transfer(src, dst, randomLong());
    }
}
