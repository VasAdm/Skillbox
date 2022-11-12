public class IndividualBusinessman extends Client {
    public IndividualBusinessman() {
        super.put(0);
    }
    public void put(double amountToPut) {
        double amountWithPercents = amountToPut < 1000 ? amountToPut * 0.99 : amountToPut * 0.995;
        super.put(amountWithPercents);
    }
}
