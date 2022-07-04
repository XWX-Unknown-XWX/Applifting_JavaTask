package microservice.task.applifting.service;

import microservice.task.applifting.exception.NotFoundException;
import microservice.task.applifting.model.MonitoredEndpoint;
import microservice.task.applifting.repository.MonitoredEpRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoredEpImp implements MonitoredEpService {

    private final MonitoredEpRep MEPRepository;

    @Autowired
    public MonitoredEpImp(MonitoredEpRep MEPRepository) {
        this.MEPRepository = MEPRepository;
    }

    public MonitoredEndpoint findById(Long id) {
        if (id == null) {
            throw new RuntimeException();
        }
        return MEPRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MONITORED_ENDPOINT_NOT_FOUND"));
    }
}
