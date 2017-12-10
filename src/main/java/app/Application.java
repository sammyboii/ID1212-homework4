package app;

import data.ConversionRateRepository;
import models.ConversionRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"data","services", "dto","controllers"})
@EntityScan("models")
@EnableJpaRepositories("data")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ConversionRateRepository repository) {
        return (args) -> {
            // seed rates
            repository.save(new ConversionRate("SEK","USD", 8.50));
            repository.save(new ConversionRate("SEK","CNY", 1.28));
            repository.save(new ConversionRate("SEK","EUR", 9.98));

            repository.save(new ConversionRate("USD","SEK", 0.12));
            repository.save(new ConversionRate("USD","CNY", 0.15));
            repository.save(new ConversionRate("USD","EUR", 1.17));

            repository.save(new ConversionRate("EUR","USD", 0.85));
            repository.save(new ConversionRate("EUR","CNY", 0.13));
            repository.save(new ConversionRate("EUR","SEK", 0.10));

            repository.save(new ConversionRate("CNY","USD", 6.62));
            repository.save(new ConversionRate("CNY","SEK", 0.78));
            repository.save(new ConversionRate("CNY","EUR", 7.77));

            log.info("Seeded conversion rates");
        };
    }
}