import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<Long, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    private static final int limit = 50000;

    public synchronized boolean isFraud(Long fromAccountNum, Long toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(Long fromAccountNum, Long toAccountNum, long amount) {
        Account src = accounts.get(fromAccountNum);
        Account dst = accounts.get(toAccountNum);

        if (src.getMoney() >= amount) {

            if (amount <= limit && (!src.isBlocked() && !dst.isBlocked())) {

                operation(src, dst, amount);
            } else {

                try {

                    boolean sbCheck = isFraud(fromAccountNum, toAccountNum, amount);
                    if (!sbCheck) operation(src, dst, amount);
                    else {
                        System.out.printf("Попытка перевода %d у.е. со счёта - %d(статус - %b) баланс - %d на счёт - %d(статус - %b) отклонена.\n", amount, src.getAccNumber(), src.isBlocked(), src.getMoney(), dst.getAccNumber(), dst.isBlocked());
                        blockAccounts(src, dst);
                    }
                } catch (InterruptedException ex) {

                    ex.printStackTrace();
                }
            }

        } else System.out.printf("Попытка перевода %d у.е. со счёта - %d(статус - %b) баланс - %d на счёт - %d(статус - %b) отклонена.\n", amount, src.getAccNumber(), src.isBlocked(), src.getMoney(), dst.getAccNumber(), dst.isBlocked());

    }


    public long getBalance(Long accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Long id : accounts.keySet()) {
            sum += getBalance(id);
        }
        return sum;
    }

    private void operation(Account src, Account dst, long amount) {
        src.setMoney(src.getMoney() - amount);
        dst.setMoney(dst.getMoney() + amount);
        System.out.printf("Попытка перевода %d у.е. со счёта - %d(статус - %b) баланс - %d на счёт - %d(статус - %b) успешна.\n", amount, src.getAccNumber(), src.isBlocked(), src.getMoney(), dst.getAccNumber(), dst.isBlocked());
    }

    private void blockAccounts(Account... accounts) {
        for (Account account : accounts) {
            account.setBlocked(true);
            System.out.printf("Аккаунт - %d заблокирован.\n", account.getAccNumber());
        }
    }

    public Map<Long, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Long key, Account account) {
        accounts.put(key, account);
    }
}
