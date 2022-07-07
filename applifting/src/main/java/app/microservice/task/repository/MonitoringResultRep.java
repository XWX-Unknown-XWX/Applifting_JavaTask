package app.microservice.task.repository;

import app.microservice.task.model.MonitoringResult;
import org.springframework.data.repository.CrudRepository;

public interface MonitoringResultRep extends CrudRepository<MonitoringResult, Long> {

    boolean existsById(Integer id);
}
