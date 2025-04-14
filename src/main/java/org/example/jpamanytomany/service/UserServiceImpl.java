package org.example.jpamanytomany.service;

import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.Generated;
import org.example.jpamanytomany.entities.Role;
import org.example.jpamanytomany.entities.User;
import org.example.jpamanytomany.repositories.RoleRepository;
import org.example.jpamanytomany.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return (User)this.userRepository.save(user);
    }

    public Role addNewRole(Role role) {
        return (Role)this.roleRepository.save(role);
    }

    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    public Role findRoleByRolename(String rolename) {
        return this.roleRepository.findByRoleName(rolename);
    }

    public void addRoleToUser(String username, String roleName) {
        User user = this.findUserByUsername(username);
        Role role = this.findRoleByRolename(roleName);
        if (user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

    }

    public User authenticate(String username, String password) {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        } else if (user.getPassword().equals(password)) {
            return user;
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Generated
    public UserServiceImpl(final UserRepository userRepository, final RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
}

