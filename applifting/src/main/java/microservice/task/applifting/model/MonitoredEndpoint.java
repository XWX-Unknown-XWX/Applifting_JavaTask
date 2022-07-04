package microservice.task.applifting.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MonitoredEndpoint")
@NamedQueries({
        @NamedQuery(
                name = "MonitoredEndpoint.findByIdIn",
                query = "SELECT m FROM MonitoredEndpoint m WHERE m.id = :id"
        ),})
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

    public MonitoredEndpoint(String name, String url, User owner) {
        this();
        this.name = name;
        this.url = url;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{" +
                "name: \"" + name + "\"," +
                "url: \"" + url + "\"," +
                "dateOfCreation: \"" + dateOfCreation + "\"," +
                "dateOfLastCheck: \"" + dateOfLastCheck + "\"," +
                "monitoredInterval: \"" + monitoredInterval + "\"," +
                "owner: \"" + owner + "\"" +
                "}";
    }
}
