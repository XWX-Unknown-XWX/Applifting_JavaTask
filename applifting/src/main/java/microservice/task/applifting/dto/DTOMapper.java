package microservice.task.applifting.dto;

import microservice.task.applifting.model.MonitoredEndpoint;
import microservice.task.applifting.model.MonitoringResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    EndpointDTO endpointToDTO(MonitoredEndpoint monitoredEndpoint);

    MonitoredEndpoint endpointDTOToMonitoredEndpoint(EndpointDTO endpointToDTO);

    ResultDTO monitorResultToDTO(MonitoringResult monitoringResult);

    MonitoringResult resultDTOToMonitoringResult(ResultDTO monitorResultToDTO);

}
