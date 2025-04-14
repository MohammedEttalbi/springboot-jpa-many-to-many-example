package org.example.jpamanytomany;

import org.example.jpamanytomany.entities.Role;
import org.example.jpamanytomany.entities.User;
import org.example.jpamanytomany.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaManyToManyApplication {
    public JpaManyToManyApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaManyToManyApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService) {
        return (args) -> {
            User u1 = new User();
            u1.setUsername("user1");
            u1.setPassword("123456");
            userService.addNewUser(u1);
            User u2 = new User();
            u2.setUsername("admin1");
            u2.setPassword("123456");
            userService.addNewUser(u2);
            Role role1 = new Role();
            role1.setRoleName("Etudiant");
            role1.setDesc("bal");
            userService.addNewRole(role1);
            userService.addRoleToUser("user1", "Etudiant");
            userService.addRoleToUser("admin1", "Etudiant");

            try {
                User user = userService.authenticate("user1", "123456");
                System.out.println(user.getUsername());
                System.out.println(user.getUserId());
                System.out.println("Roles=>");
                user.getRoles().forEach((role) -> System.out.println(role));
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }
}
