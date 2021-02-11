package spring.core.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.core.dto.UserResponseDto;
import spring.core.model.User;
import spring.core.service.UserMapper;
import spring.core.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserMapper userMapper;
    private UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @RequestMapping(value = "/user/inject", method = RequestMethod.GET)
    public String inject() {
        User userOne = new User();
        userOne.setName("Alice");
        User userTwo = new User();
        userTwo.setName("Bob");
        User userThree = new User();
        userThree.setName("Bob");
        User userFour = new User();
        userFour.setName("Bob");
        return "injected four users";
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        return userMapper.mapToDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(user -> userMapper.mapToDto(user))
                .collect(Collectors.toList());
    }
}
