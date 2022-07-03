package microservice.task.applifting;

import microservice.task.applifting.model.MonitoredEndpoint;
import microservice.task.applifting.model.MonitoringResult;
import microservice.task.applifting.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

        MonitoredEndpoint monitoredEndpoint1 = new GeneratorTemp().createMEP("", "", user1);
        monitoredEndpoint1.setMonitoredInterval((int) TimeUnit.MINUTES.toSeconds(8));
        // continue monitoredEndpoint1 here...

        MonitoredEndpoint monitoredEndpoint2 = new GeneratorTemp().createMEP("", "", user2);
        monitoredEndpoint2.setMonitoredInterval((int) TimeUnit.MINUTES.toSeconds(8));
        // continue monitoredEndpoint2 here...

        MonitoringResult monitoringResult1 = new GeneratorTemp().createMR("", monitoredEndpoint1);
        // continue monitoringResult1 here...

        MonitoringResult monitoringResult2 = new GeneratorTemp().createMR("", monitoredEndpoint2);
        // continue monitoringResult2 here
    }
}
