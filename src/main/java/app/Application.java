package app;

import data.ExchangeRateRepository;
import models.ExchangeRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"data","services", "dto","controllers"})
@EntityScan("models")
@EnableJpaRepositories("data")
@EnableTransactionManagement
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ExchangeRateRepository repository) {
        return (args) -> {
            // seed rates
            repository.save(new ExchangeRate("SEK","USD", 8.50));
            repository.save(new ExchangeRate("SEK","CNY", 1.28));
            repository.save(new ExchangeRate("SEK","EUR", 9.98));

            repository.save(new ExchangeRate("USD","SEK", 0.12));
            repository.save(new ExchangeRate("USD","CNY", 0.15));
            repository.save(new ExchangeRate("USD","EUR", 1.17));

            repository.save(new ExchangeRate("EUR","USD", 0.85));
            repository.save(new ExchangeRate("EUR","CNY", 0.13));
            repository.save(new ExchangeRate("EUR","SEK", 0.10));

            repository.save(new ExchangeRate("CNY","USD", 6.62));
            repository.save(new ExchangeRate("CNY","SEK", 0.78));
            repository.save(new ExchangeRate("CNY","EUR", 7.77));

            log.info("Seeded conversion rates");
        };
    }
}