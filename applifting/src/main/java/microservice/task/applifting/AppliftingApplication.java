package microservice.task.applifting;

import microservice.task.applifting.model.MonitoringResult;
import microservice.task.applifting.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class AppliftingApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AppliftingApplication.class);

    private static final UUID uuid = UUID.randomUUID();

    public static void main(String[] args) {
        SpringApplication.run(AppliftingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("AppliftingApplication...");
        User user1 = new User("Applifting", "info@applifting.cz");
        user1.setAccessToken(uuid.toString());
        User user2 = new User("Batman", "batman@example.com");
        user2.setAccessToken(uuid.toString());
        // continue user here...
    }
}
