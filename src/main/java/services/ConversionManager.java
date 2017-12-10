package services;

import dto.ConversionDTO;
import data.ConversionRateRepository;
import models.ConversionRate;
import models.ConversionRateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

@Service
public class ConversionManager {

    @Autowired
    private ConversionRateRepository repository;

    public String convert(ConversionDTO dto) {
        DecimalFormat format = new DecimalFormat("##.## " + dto.getToCurrency());
        if (convertToSame(dto)) {
            return format.format(dto.getAmount());
        }
        ConversionRate conversion = repository.findOne(
               new ConversionRateID(dto.getFromCurrency(), dto.getToCurrency()));
        double result = dto.getAmount() / conversion.getRate();
        return format.format(result);
    }

    public Set<String> getFromCurrencies() {
        Iterable<ConversionRate> records = repository.findAll();
        Set<String> result = new HashSet<>();
        records.forEach(record -> result.add(record.getFromCurrency()));
        return result;
    }

    public Set<String> getToCurrencies() {
        Iterable<ConversionRate> records = repository.findAll();
        Set<String> result = new HashSet<>();
        records.forEach(record -> result.add(record.getToCurrency()));
        return result;
    }

    private boolean convertToSame(ConversionDTO dto) {
        return dto.getFromCurrency().equals(dto.getToCurrency());
    }
}
