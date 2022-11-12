public class CardAccount extends BankAccount {
    protected boolean take(double amountToTake) {
        amountToTake *= 1.01;
        if (amount >= amountToTake) {
            amount -= amountToTake;
            return true;
        } else return false;
    }
}
