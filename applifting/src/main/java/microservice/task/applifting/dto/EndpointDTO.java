package microservice.task.applifting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import microservice.task.applifting.model.User;

import javax.persistence.Transient;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class EndpointDTO implements Cloneable {

    private String name;

    private String url;
    private Timestamp dateOfCreation;

    private Timestamp dateOfLastCheck;

    private Integer monitoredInterval;

    @Transient
    private User owner;


    @Override
    public EndpointDTO clone() {
        try {
            EndpointDTO clone = (EndpointDTO) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return new EndpointDTO(name, url, dateOfCreation, dateOfLastCheck, monitoredInterval, owner);
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
