package microservice.task.applifting;

import microservice.task.applifting.model.MonitoredEndpoint;
import microservice.task.applifting.model.MonitoringResult;
import microservice.task.applifting.model.User;

import java.sql.Timestamp;

public class GeneratorTemp {


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
