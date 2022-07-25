package utility;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static boolean isInvalidString(String s) {
        return s == null || s.isBlank();
    }

    public static boolean isInvalidMoneyAmount(BigDecimal money) {
        return money == null || money.compareTo(BigDecimal.ZERO) < 0;
    }

    public static <T> String listJoin(String sep, List<T> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return list.stream()
                .map(T::toString)
                .collect(Collectors.joining(sep))
                .strip();
    }
}
