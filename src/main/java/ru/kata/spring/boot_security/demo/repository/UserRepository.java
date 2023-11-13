package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository {
//    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = ?username")
    User findByUsername(String username);

    void save(User user);

    Optional<User> findById(Long id);

    void deleteById(Long id);

    List<User> findAll();
}
