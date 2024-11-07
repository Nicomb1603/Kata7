package architecture.model;

import java.util.Objects;

public class Currency {
    private String name;
    private String symbol;
    private String code;

    public Currency(String name, String code, String symbol){
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public Currency(String name, String code){
        this(name, code, "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) && Objects.equals(symbol, currency.symbol) && Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, code);
    }

    @Override
    public String toString() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }
}
