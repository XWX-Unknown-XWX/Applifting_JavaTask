package app.microservice.task.controller;


import app.microservice.task.dto.DTOMapper;
import app.microservice.task.dto.EndpointDTO;
import app.microservice.task.service.MonitoredEpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoredEpController {

    private final MonitoredEpService MEPService;

    private final DTOMapper mapper;

    @Autowired
    public MonitoredEpController(MonitoredEpService mepService, DTOMapper mapper) {
        this.MEPService = mepService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public EndpointDTO getEndpointById(@PathVariable Long id) {
        return mapper.endpointToDTO(MEPService.findById(id));
    }
}
