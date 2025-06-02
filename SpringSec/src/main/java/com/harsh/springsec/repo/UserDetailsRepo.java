package com.harsh.springsec.repo;

import com.harsh.springsec.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
