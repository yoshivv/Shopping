package YOSHI.Shopping.service;

import YOSHI.Shopping.domain.User;
import YOSHI.Shopping.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {


    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(User user){

        userRepository.findById(user.getId()).
                ifPresent(user1 -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
        userRepository.save(user);

        return user.getNum();
    }


}
