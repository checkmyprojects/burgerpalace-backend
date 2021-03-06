package com.bugerpalace.burgerpalacebackend.repo;

import com.bugerpalace.burgerpalacebackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
