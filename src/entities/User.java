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

    public boolean hasMoneyAmount(BigDecimal moneyToSpend) {
        return moneyAmount.compareTo(moneyToSpend) >= 0;
    }

    public void spendMoney(BigDecimal moneyToSpend) {
        if (hasMoneyAmount(moneyToSpend)) {
            moneyAmount = moneyAmount.subtract(moneyToSpend);
        }
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
