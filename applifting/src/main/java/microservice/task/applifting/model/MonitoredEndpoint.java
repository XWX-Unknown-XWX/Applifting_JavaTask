package microservice.task.applifting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MonitoredEndpoint")
@Getter
@Setter
public class MonitoredEndpoint extends AbstractID {

    private String name;

    private String url;
    private Timestamp dateOfCreation;

    private Timestamp dateOfLastCheck;
    private Integer monitoredInterval;
    @Transient
    private User owner;

    public MonitoredEndpoint() {

    }

//    @Override
//    public String toString() {
//        return "{" +
//                "name: \"" + name + "\"," +
//                "url: \"" + url + "\"," +
//                "dateOfCreation: \"" + dateOfCreation + "\"," +
//                "dateOfLastCheck: \"" + dateOfLastCheck + "\"," +
//                "monitoredInterval: \"" + monitoredInterval + "\"," +
//                "owner: \"" + owner + "\"" +
//                "}";
//    }
}
