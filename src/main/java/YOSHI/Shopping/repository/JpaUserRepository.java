package YOSHI.Shopping.repository;


import YOSHI.Shopping.domain.User;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User user) {

        em.persist(user);

        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        List<User> result= em.createQuery("select m from User m where m.id= :id",User.class)
                .setParameter("id",id)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByName(String name) {
        List<User> result= em.createQuery("select m from User m where m.name= :name",User.class)
                .setParameter("name",name)
                .getResultList();

        return result.stream().findAny();
    }
}
