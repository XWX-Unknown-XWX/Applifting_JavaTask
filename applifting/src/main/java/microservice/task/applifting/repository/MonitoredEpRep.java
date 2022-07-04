package microservice.task.applifting.repository;

import microservice.task.applifting.model.MonitoredEndpoint;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface MonitoredEpRep extends CrudRepository<MonitoredEndpoint, Long> {

    List<MonitoredEndpoint> findByIdIn(Collection<Integer> id);

    boolean existsAllByIdIn(Collection<Integer> id);
}
