package utility;

import java.math.BigDecimal;

public class Util {
    public static boolean isInvalidString(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isInvalidMoneyAmount(BigDecimal money) {
        return money == null || money.compareTo(BigDecimal.ZERO) < 0;
    }
}
