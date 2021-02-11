package spring.core.service;

import spring.core.dto.UserResponseDto;
import spring.core.model.User;

public interface UserMapper {
    UserResponseDto mapToDto(User user);
}
