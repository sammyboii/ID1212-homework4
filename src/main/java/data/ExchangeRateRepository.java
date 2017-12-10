package data;

import models.ExchangeRate;
import models.ExchangeRateID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, ExchangeRateID> {
}
