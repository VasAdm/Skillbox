public class Manager extends Worker {
    public static final double MANAGERS_MULTIPLIER = 0.05;
    private final int sales = (int) (Math.random() * 25000 + 115000);

    public Manager(int salary) {
        super(salary);
    }
    @Override
    public int getMonthSalary() {
        return (int) (super.getMonthSalary() + MANAGERS_MULTIPLIER * sales);
    }

    public int getSales() {
        return sales;
    }
}
