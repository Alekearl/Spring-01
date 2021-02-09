package spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.config.AppConfig;
import spring.core.model.User;
import spring.core.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);

        User userOne = new User();
        userOne.setName("Michael");
        userService.add(userOne);
        User userTwo = new User();
        userTwo.setName("Helen");
        userService.add(userTwo);
        System.out.println(userService.listUsers());
    }
}
