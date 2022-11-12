import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    protected void put(double amountToPut) {
        if (amountToPut > 0) amount += amountToPut;
        lastIncome = LocalDate.now();
    }

    protected boolean take(double amountToTake) {
        if (lastIncome.until(LocalDate.now(), ChronoUnit.MONTHS) >= 1) {
            if (amount >= amountToTake) {
                amount -= amountToTake;
                return true;
            }
        }
        return false;
    }
}
