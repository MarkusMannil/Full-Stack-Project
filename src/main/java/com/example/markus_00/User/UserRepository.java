
package com.example.markus_00.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Class for connecting database and UserService
 */
@Repository
public interface UserRepository extends JpaRepository<User0, Long> {
    /**
     * Query for finding user by name
     */
    Optional<User0> findUser0ByName(String name);
}