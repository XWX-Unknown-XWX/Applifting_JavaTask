package app.microservice.task.service;

import app.microservice.task.model.MonitoringResult;
import app.microservice.task.repository.MonitoringResultRep;
import app.microservice.task.exception.NotFoundException;
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
