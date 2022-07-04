package microservice.task.applifting.service;

import microservice.task.applifting.model.MonitoredEndpoint;

public interface MonitoredEpService {

    MonitoredEndpoint findById(Long id);

}
