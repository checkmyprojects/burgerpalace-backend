package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Role;
import com.bugerpalace.burgerpalacebackend.domain.User;
import com.bugerpalace.burgerpalacebackend.repo.RoleRepo;
import com.bugerpalace.burgerpalacebackend.repo.UserRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private RoleRepo roleRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImpl undertest;

    @BeforeEach
    void setUp(){ undertest = new UserServiceImpl(userRepo, roleRepo, passwordEncoder);}

    @Test
    void loadUserByUsername() {
        User user = new User(
                null,
                "userTesting",
                "user street",
                "user@mail.com",
                "123321123",
                "password",
                new ArrayList<>(),
                null
        );
    }

    @Test
    void saveUser() {
        User user = new User(
                null,
                "userTesting",
                "user street",
                "user@mail.com",
                "123321123",
                "password",
                new ArrayList<>(),
                null
        );
        undertest.saveUser(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepo).save(userArgumentCaptor.capture());

        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void saveRole() {
        Role role = new Role(1L, "ROLE_USER");
        undertest.saveRole(role);
        verify(roleRepo).save(role);
    }

    @Test
    void addRoleToUser() {
        User user = new User(
                1L,
                "userTesting",
                "user street",
                "user@mail.com",
                "123321123",
                "password",
                new ArrayList<>(),
                null
        );

        Role role = new Role(1L, "ROLE_USER");
        user.getRoles().add(role);
        assertThat(user.getRoles()).toString().contains("ROLE_USER");
        //userService.addRoleToUser("admin@mail.com", "ROLE_ADMIN");
    }

    @Test
    void getUser() {
        undertest.getUser("username");
        verify(userRepo).findByUsername("username");
    }

    @Test
    void getUsers() {
        undertest.getUsers();
        verify(userRepo).findAll();
    }

    @Test
    void findUserById() {
        User user = new User(
                1L,
                "userTesting",
                "user street",
                "user@mail.com",
                "123321123",
                "password",
                new ArrayList<>(),
                null
        );
        undertest.saveUser(user);
        undertest.findUserById(1L);
        verify(userRepo).findById(1L);
    }

    @Test
    void findByUsername() {
        undertest.findByUsername("username");
        verify(userRepo).findByUsername("username");
    }

    @Test
    void deleteUserById() {
        undertest.deleteUserById(1L);
        verify(userRepo).deleteById(1L);
    }
}