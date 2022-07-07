package app.microservice.task.dto;

import app.microservice.task.model.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DTOMapper {

    EndpointDTO endpointToDTO(MonitoredEndpoint monitoredEndpoint);

    ResultDTO monitorResultToDTO(MonitoringResult monitoringResult);

    UserDTO userToDTO(User user);

}
