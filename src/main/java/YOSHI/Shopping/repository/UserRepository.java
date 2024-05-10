package YOSHI.Shopping.repository;

import YOSHI.Shopping.domain.User1;

import java.util.Optional;

public interface UserRepository {

    User1 save(User1 user);

    Optional<User1> findById(String id);
    Optional<User1> findByName(String name);



}
