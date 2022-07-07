package app.microservice.task;

import app.microservice.task.model.MonitoredEndpoint;
import app.microservice.task.model.MonitoringResult;
import app.microservice.task.model.User;
import app.microservice.task.repository.SaveEntityFacade;
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

    private final SaveEntityFacade saveEntityFacade;

    public AppliftingApplication(SaveEntityFacade saveEntityFacade) {
        this.saveEntityFacade = saveEntityFacade;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppliftingApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("AppliftingApplication...");

        User user1 = new User("Applifting", "info@applifting.cz");
        user1.setAccessToken(uuid.toString());
        saveEntityFacade.userResult(user1);

        User user2 = new User("Batman", "batman@example.com");
        user2.setAccessToken(uuid.toString());
        saveEntityFacade.userResult(user2);

        MonitoredEndpoint monitoredEndpoint1 = new GeneratorTemp().createMEP("", "", user1);
        monitoredEndpoint1.setMonitoredInterval((int) TimeUnit.MINUTES.toSeconds(8));
        saveEntityFacade.monitoredEndpoint(monitoredEndpoint1);

        MonitoredEndpoint monitoredEndpoint2 = new GeneratorTemp().createMEP("", "", user2);
        monitoredEndpoint2.setMonitoredInterval((int) TimeUnit.MINUTES.toSeconds(8));
        saveEntityFacade.monitoredEndpoint(monitoredEndpoint2);

        MonitoringResult monitoringResult1 = new GeneratorTemp().createMR("", monitoredEndpoint1);
        saveEntityFacade.monitoringResult(monitoringResult1);

        MonitoringResult monitoringResult2 = new GeneratorTemp().createMR("", monitoredEndpoint2);
        saveEntityFacade.monitoringResult(monitoringResult2);
    }
}
