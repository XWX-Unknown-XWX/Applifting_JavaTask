package app.microservice.task.dto;

import app.microservice.task.model.MonitoredEndpoint;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class ResultDTO implements Cloneable {

    private Timestamp dateOfCheck;

    private Integer returnedHttpStatusCode;

    private String returnedPayload;

    @Transient
    private MonitoredEndpoint monitoredEndpointId;

    @Override
    public ResultDTO clone() {
        try {
            ResultDTO clone = (ResultDTO) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return new ResultDTO(dateOfCheck, returnedHttpStatusCode, returnedPayload, monitoredEndpointId);
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
