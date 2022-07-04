package microservice.task.applifting.controller;


import microservice.task.applifting.dto.DTOMapper;
import microservice.task.applifting.dto.EndpointDTO;
import microservice.task.applifting.service.MonitoredEpService;
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
        MEPService = mepService;
        this.mapper = mapper;
    }

    @GetMapping("/monitored/endpoints/{id}")
    public EndpointDTO getEndpointById(@PathVariable Long id) {
        return mapper.endpointToDTO(MEPService.findById(id));
    }
}
