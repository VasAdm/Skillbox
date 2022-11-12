public class TopManager extends Worker{
    public static final int MIN_INCOME = 10_000_000;
    public static final double MULTIPLIER = 1.5;
    private final Company company;

    public TopManager(int salary, Company company) {
        super(salary);
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int salary = super.getMonthSalary();
        if (company.getIncome() > MIN_INCOME)
            return (int) (salary * MULTIPLIER);
        return salary;
    }
}
