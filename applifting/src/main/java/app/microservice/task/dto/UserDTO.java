package app.microservice.task.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

    private String username;

    private String email;

    private String accessToken;

    @Override
    public UserDTO clone() {
        try {
            UserDTO clone = (UserDTO) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return new UserDTO(username, email, accessToken);
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }

    }

}
