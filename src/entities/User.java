package entities;

import java.math.BigDecimal;

public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
    private BigDecimal moneyAmount;

    public User(int id, String firstName, String lastName, BigDecimal moneyAmount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.moneyAmount = moneyAmount;
    }

    public boolean spendMoney(BigDecimal moneyToSpend) {
        boolean hasMoneyAmount = moneyAmount.compareTo(moneyToSpend) >= 0;
        if (hasMoneyAmount) {
            moneyAmount = moneyAmount.subtract(moneyToSpend);
        }
        return hasMoneyAmount;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }
}
