package services;

import dto.ConversionDTO;
import data.ExchangeRateRepository;
import models.ExchangeRate;
import models.ExchangeRateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class ConversionManager {

    @Autowired
    private ExchangeRateRepository repository;


    public String convert(ConversionDTO dto) {
        DecimalFormat format = new DecimalFormat("##.## " + dto.getToCurrency());
        if (convertToSame(dto)) {
            return format.format(dto.getAmount());
        }
        ExchangeRate conversion = repository.findOne(
               new ExchangeRateID(dto.getFromCurrency(), dto.getToCurrency()));
        double result = dto.getAmount() / conversion.getRate();
        return format.format(result);
    }

    public Set<String> getFromCurrencies() {
        Iterable<ExchangeRate> records = repository.findAll();
        Set<String> result = new HashSet<>();
        records.forEach(record -> result.add(record.getFromCurrency()));
        return result;
    }

    public Set<String> getToCurrencies() {
        Iterable<ExchangeRate> records = repository.findAll();
        Set<String> result = new HashSet<>();
        records.forEach(record -> result.add(record.getToCurrency()));
        return result;
    }

    private boolean convertToSame(ConversionDTO dto) {
        return dto.getFromCurrency().equals(dto.getToCurrency());
    }
}
