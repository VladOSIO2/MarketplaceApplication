package entities;

import java.math.BigDecimal;

public record User(int id, String firstName, String lastName, BigDecimal moneyAmount) {
}
