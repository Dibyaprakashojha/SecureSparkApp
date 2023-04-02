package com.acxtech.securesparkapp.repository;

import com.acxtech.securesparkapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTUserRepository extends JpaRepository<JWTUser, Long> {
    public JWTUser findByUsername(String username);
}
