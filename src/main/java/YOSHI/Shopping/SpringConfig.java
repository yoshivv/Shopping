package YOSHI.Shopping;

import YOSHI.Shopping.repository.JpaUserRepository;
import YOSHI.Shopping.repository.UserRepository;
import YOSHI.Shopping.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }


    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
}
