package app.microservice.task.service;

import app.microservice.task.model.MonitoredEndpoint;

public interface MonitoredEpService {

    MonitoredEndpoint findById(Long id);

}
