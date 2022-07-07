package app.microservice.task.repository;

import app.microservice.task.model.MonitoredEndpoint;
import app.microservice.task.model.MonitoringResult;
import app.microservice.task.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveEntityFacade {

    private final MonitoredEpRep monitoredEpRep;

    private final UserRepository userRepository;

    private final MonitoringResultRep monitoringResultRep;

    @Autowired
    public SaveEntityFacade(MonitoredEpRep monitoredEpRep, UserRepository userRepository, MonitoringResultRep monitoringResultRep) {
        this.monitoredEpRep = monitoredEpRep;
        this.userRepository = userRepository;
        this.monitoringResultRep = monitoringResultRep;
    }

    public MonitoredEndpoint monitoredEndpoint(MonitoredEndpoint entity) {
        return monitoredEpRep.save(entity);
    }

    public MonitoringResult monitoringResult(MonitoringResult entity) {
        return monitoringResultRep.save(entity);
    }

    public User userResult(User entity) {
        return userRepository.save(entity);
    }
}
