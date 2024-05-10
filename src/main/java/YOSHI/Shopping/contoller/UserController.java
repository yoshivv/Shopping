package YOSHI.Shopping.contoller;

import YOSHI.Shopping.domain.User1;
import YOSHI.Shopping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public String login(UserForm userForm){

        System.out.println(userForm.getId());
        System.out.println(userForm.getPass());

        return "home";
    }

    @GetMapping("user/join")
    public String joinP(){

        return "/user/joinPage";
    }

    @PostMapping("user/join")
    public String join(UserForm userForm){
        User1 user = new User1();
        user.setId(userForm.getId());
        user.setName(userForm.getName());
        user.setPassword(userForm.getPass());

        System.out.println(user.getId()+"===");

        userService.join(user);

        return "home";
    }

}
