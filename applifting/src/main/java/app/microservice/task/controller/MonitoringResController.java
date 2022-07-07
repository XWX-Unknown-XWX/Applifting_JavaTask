package app.microservice.task.controller;

import app.microservice.task.dto.DTOMapper;
import app.microservice.task.service.MonitoringResultService;
import app.microservice.task.dto.ResultDTO;
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

    @GetMapping("/{id}")
    public ResultDTO getMonitoringResultById(@PathVariable Long id) {
        return mapper.monitorResultToDTO(resultService.findById(id));
    }
}
