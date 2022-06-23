package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Role;
import com.bugerpalace.burgerpalacebackend.domain.User;
import com.bugerpalace.burgerpalacebackend.repo.RoleRepo;
import com.bugerpalace.burgerpalacebackend.repo.UserRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        Role role = new Role(1L, "ROLE_USER");
        user.getRoles().add(role);
        given(userRepo.findByUsername("user@mail.com")).willReturn(user);
        undertest.loadUserByUsername("user@mail.com");
        verify(userRepo).findByUsername("user@mail.com");
    }

    @Test
    void itThrowsAnExceptionWhenUserNotFound() {
        given(userRepo.findByUsername("user@mail.com")).willReturn(null);

        assertThatThrownBy(() -> undertest.loadUserByUsername("user@mail.com")).isInstanceOf(UsernameNotFoundException.class).hasMessageContaining("User not found in the database");
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

        given(userRepo.findByUsername("userTesting")).willReturn(user);
        given(roleRepo.findByName("ROLE_USER")).willReturn(role);


        undertest.addRoleToUser("userTesting", "ROLE_USER");
        verify(userRepo).findByUsername("userTesting");
        verify(roleRepo).findByName("ROLE_USER");
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
        given(userRepo.findById(user.getId())).willReturn(Optional.of(user));
        undertest.findUserById(user.getId());
        verify(userRepo).findById(user.getId());
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