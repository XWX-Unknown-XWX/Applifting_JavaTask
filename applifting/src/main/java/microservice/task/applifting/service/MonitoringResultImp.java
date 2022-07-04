package microservice.task.applifting.service;

import microservice.task.applifting.exception.NotFoundException;
import microservice.task.applifting.model.MonitoringResult;
import microservice.task.applifting.repository.MonitoringResultRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoringResultImp implements MonitoringResultService {

    private final MonitoringResultRep MRRepository;

    @Autowired
    public MonitoringResultImp(MonitoringResultRep MRRepository) {
        this.MRRepository = MRRepository;
    }

    public MonitoringResult findById(Long id) {
        if (id == null) {
         throw new RuntimeException();
        }
        return MRRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("MONITORING_RESULT_NOT_FOUND"));
    }
}
