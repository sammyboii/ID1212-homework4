package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(value= ExchangeRateID.class)
public class ExchangeRate {
    @Id public String fromCurrency;
    @Id public String toCurrency;
    public double rate;

    protected ExchangeRate() {}

    public ExchangeRate(String fromCurrency, String toCurrency, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format(
                "ExchangeRate[fromCurrency=%s, toCurrency=%s, rate=%f]",
                fromCurrency, toCurrency, rate
        );
    }
}
