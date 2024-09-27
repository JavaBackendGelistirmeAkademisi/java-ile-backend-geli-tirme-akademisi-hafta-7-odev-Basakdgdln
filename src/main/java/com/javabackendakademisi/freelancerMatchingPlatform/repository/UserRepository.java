package com.javabackendakademisi.freelancerMatchingPlatform.repository;

import com.javabackendakademisi.freelancerMatchingPlatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// User için JPA repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByName(String name);
}