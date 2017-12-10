package models;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ExchangeRateID implements Serializable {
    @NotNull String fromCurrency;
    @NotNull String toCurrency;

    public ExchangeRateID() {}

    public ExchangeRateID(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRateID that = (ExchangeRateID) o;
        return Objects.equals(fromCurrency, that.fromCurrency) &&
                Objects.equals(toCurrency, that.toCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCurrency, toCurrency);
    }
}
