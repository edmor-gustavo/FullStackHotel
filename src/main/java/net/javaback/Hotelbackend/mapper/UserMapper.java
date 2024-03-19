package net.javaback.Hotelbackend.mapper;

import net.javaback.Hotelbackend.dto.UserDto;
import net.javaback.Hotelbackend.entity.User;

public class UserMapper {
    public static UserDto mapUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword()
                // Mapear outros campos conforme necessário
        );
    }

    public static User mapUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
                // Mapear outros campos conforme necessário
        );
    }
}
