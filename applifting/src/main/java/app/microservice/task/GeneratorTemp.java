package app.microservice.task;

import app.microservice.task.model.MonitoredEndpoint;
import app.microservice.task.model.MonitoringResult;
import app.microservice.task.model.User;

import java.sql.Timestamp;

public class GeneratorTemp {

    // FIXME: 04.07.2022: Check if it is correct (12-22)
    public MonitoredEndpoint createMEP(String name, String url, User owner) {
        MonitoredEndpoint mep = new MonitoredEndpoint(name, url, owner);
        mep.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        return mep;
    }

    public MonitoringResult createMR(String returnedPayload, MonitoredEndpoint monitoredEPId) {
        MonitoringResult mr = new MonitoringResult(returnedPayload, monitoredEPId);
        mr.setDateOfCheck(new Timestamp(System.currentTimeMillis()));
        return mr;
    }
}
