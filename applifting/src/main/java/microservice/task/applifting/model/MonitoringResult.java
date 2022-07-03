package microservice.task.applifting.model;

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

//    public MonitoringResult(Timestamp dateOfCheck,Integer returnedHttp,
//                            String returnedPayload, MonitoredEndpoint monitoredEPId) {
//        this.dateOfCheck = dateOfCheck;
//        this.returnedHttpStatusCode = returnedHttp;
//        this.returnedPayload = returnedPayload;
//        this.monitoredEndpointId = monitoredEPId;
//    }
}
