package entities;

import java.math.BigDecimal;

public record Product(int id, String name, BigDecimal price) {
}
