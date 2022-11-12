public class LegalPerson extends Client {
    public LegalPerson() {
        super.put(0);
    }

    public void take(double amountToTake) {
        super.take(amountToTake * 1.01);
    }
}
