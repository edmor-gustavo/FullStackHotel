package net.javaback.Hotelbackend.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;
    // Outros campos, como email, roles, etc.
}
