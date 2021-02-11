package spring.core.service.serviceimpl;

import org.springframework.stereotype.Component;
import spring.core.dto.UserResponseDto;
import spring.core.model.User;
import spring.core.service.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        return userDto;
    }
}
