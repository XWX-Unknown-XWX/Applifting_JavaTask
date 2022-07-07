package app.microservice.task.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MonitoringResult")
@Getter
@Setter
public class MonitoringResult extends AbstractID {
    private Timestamp dateOfCheck;
    private Integer returnedHttpStatusCode;
    private String returnedPayload;
    @Transient
    private MonitoredEndpoint monitoredEndpointId;


    public MonitoringResult() {

    }

    public MonitoringResult(String returnedPayload, MonitoredEndpoint monitoredEPId) {
        this();
        this.returnedPayload = returnedPayload;
        this.monitoredEndpointId = monitoredEPId;
    }

    @Override
    public String toString() {
        return "{" +
                "dateOfCheck: \"" + dateOfCheck + "\"," +
                "returnedHttpStatusCode: \"" + returnedHttpStatusCode + "\"," +
                "returnedPayload: " + returnedPayload + "\"," +
                "monitoredEndpointId: " + monitoredEndpointId + "\"" +
                "}";
    }

}
