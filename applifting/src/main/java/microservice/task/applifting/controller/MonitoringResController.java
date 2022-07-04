package microservice.task.applifting.controller;

import microservice.task.applifting.dto.DTOMapper;
import microservice.task.applifting.dto.ResultDTO;
import microservice.task.applifting.service.MonitoringResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringResController {

    private final MonitoringResultService resultService;
    private final DTOMapper mapper;

    @Autowired
    public MonitoringResController(MonitoringResultService resultService, DTOMapper mapper) {
        this.resultService = resultService;
        this.mapper = mapper;
    }

    @GetMapping("/monitoring/result/{id}")
    public ResultDTO getMonitoringResultById(@PathVariable Long id) {
        return mapper.monitorResultToDTO(resultService.findById(id));
    }
}
