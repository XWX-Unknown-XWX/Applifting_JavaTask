package microservice.task.applifting.repository;

import microservice.task.applifting.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveEntityFacade {

    private final MonitoredEpRep monitoredEpRep;

    private final MonitoringResultRep monitoringResultRep;

    @Autowired
    public SaveEntityFacade(MonitoredEpRep monitoredEpRep, MonitoringResultRep monitoringResultRep) {
        this.monitoredEpRep = monitoredEpRep;
        this.monitoringResultRep = monitoringResultRep;
    }

    public MonitoredEndpoint monitoredEndpoint (MonitoredEndpoint entity) {
        return monitoredEpRep.save(entity);
    }

    public MonitoringResult monitoringResult (MonitoringResult entity) {
        return monitoringResultRep.save(entity);
    }
}
