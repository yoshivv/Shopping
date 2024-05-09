package YOSHI.Shopping.repository;

import YOSHI.Shopping.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(String id);
    Optional<User> findByName(String name);



}
