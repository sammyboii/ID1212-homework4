package data;

import models.ConversionRate;
import models.ConversionRateID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRateRepository extends CrudRepository<ConversionRate, ConversionRateID> {
    ConversionRate findOne(ConversionRateID primaryKey);
}
