package simple.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("new User " + repository.save(new User("Syimyk", "Zhantoroev")));
            log.info("new User " + repository.save(new User("Elon", "Musk")));
            log.info("new User " + repository.save(new User("Steve", "Jobs")));
        };
    }
}