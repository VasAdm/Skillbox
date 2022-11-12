public class Account {

    private volatile Long money;
    private static volatile long counter = 0;
    private volatile long accNumber = 0;
    private volatile boolean isBlocked;

    public Account() {
        isBlocked = false;
        money = 0L;
        counter++;
        accNumber = counter;
        System.out.printf("Создан аккаунт %d\n", accNumber);
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public long getAccNumber() {
        return accNumber;
    }


    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
