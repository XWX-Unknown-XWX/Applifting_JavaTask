package app.microservice.task.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User extends AbstractID {

    private String username;

    private String email;

    private String accessToken;

    public User(String username, String email) {
        this();
        this.username = username;
        this.email = email;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "{" +
                "username: \"" + username + "\"," +
                "email: \"" + email + "\"," +
                "accessToken: \"" + accessToken + "\"" +
                "}";
    }
}
