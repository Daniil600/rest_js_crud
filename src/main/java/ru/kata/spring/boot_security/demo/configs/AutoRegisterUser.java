package ru.kata.spring.boot_security.demo.configs;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.util.Set;

@Component
public class AutoRegisterUser {
    private final UserService userService;
    private final RoleService roleService;

    public AutoRegisterUser(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    private void autoSaveUser() {
        Role role_admin = new Role("ROLE_ADMIN");
        Role role_user = new Role("ROLE_USER");
        roleService.save(role_admin);
        roleService.save(role_user);

        User user_admin = new User("admin","admin", "admin", 25,"admin@mail.ru");
        User user_user = new User("user","user", "user", 25,"user@mail.ru");
        

        user_admin.setRoles(Set.of(role_admin,role_user));
        user_user.setRoles(Set.of(role_user));

        userService.saveUser(user_admin);
        userService.saveUser(user_user);

    }
}
