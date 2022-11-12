public abstract class Client {
    private double clientMoney;

    public double getAmount() {
        return clientMoney;
    }

    public void put(double amountToPut) {
        clientMoney += (amountToPut > 0) ? amountToPut: 0;
    }

    public void take(double amountToTake) {
        clientMoney -= (amountToTake > 0 && clientMoney >= amountToTake) ? amountToTake: 0;
    }
}
