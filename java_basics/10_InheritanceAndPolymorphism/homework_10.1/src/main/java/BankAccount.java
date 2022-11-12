public class BankAccount {
  protected double amount;

  protected BankAccount() {
    new BankAccount(0);
  }

  protected BankAccount(double amount) {
    this.amount = amount;
  }

  protected double getAmount() {
    return amount;
  }

  protected void put(double amountToPut) {
    if (amountToPut > 0) amount += amountToPut;
  }

  protected boolean take(double amountToTake) {
    if (amount >= amountToTake) {
      amount -= amountToTake;
      return true;
    } else return false;
  }

  protected boolean send(BankAccount receiver, double amount) {
    if (this.getAmount() >= amount && amount > 0) {
      if (this.take(amount)) {
        receiver.put(amount);
        return true;
      }
    }
    return false;
  }
}