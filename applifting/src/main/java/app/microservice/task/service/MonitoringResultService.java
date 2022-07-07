package app.microservice.task.service;

import app.microservice.task.model.MonitoringResult;

public interface MonitoringResultService {

    MonitoringResult findById(Long id);
}
