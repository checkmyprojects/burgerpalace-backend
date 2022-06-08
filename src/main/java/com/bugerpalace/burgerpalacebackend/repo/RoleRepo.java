package com.bugerpalace.burgerpalacebackend.repo;

import com.bugerpalace.burgerpalacebackend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
