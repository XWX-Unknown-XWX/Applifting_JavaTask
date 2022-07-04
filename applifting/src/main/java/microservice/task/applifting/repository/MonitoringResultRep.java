package microservice.task.applifting.repository;

import microservice.task.applifting.model.MonitoringResult;
import org.springframework.data.repository.CrudRepository;

public interface MonitoringResultRep extends CrudRepository<MonitoringResult, Long> {

    boolean existsById(Integer id);
}
