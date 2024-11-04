package architecture.model;

import java.time.LocalDate;

public record ExchangeRate(String from, String to, double rate, LocalDate date) {
}
