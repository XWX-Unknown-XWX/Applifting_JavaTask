package microservice.task.applifting.service;

import microservice.task.applifting.model.MonitoringResult;

public interface MonitoringResultService {

    MonitoringResult findById(Long id);
}
