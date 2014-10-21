import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/", produces = "application/json")
public class Example {

    @RequestMapping(value="/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value="/user")
    User user() {
        User user = new User();
        user.setName("jack");
        user.setAge(22);
        return user;
    }
    @RequestMapping(value="/userlist")
    List<User> userlist() {
        User user = new User();
        user.setName("jack");
        user.setAge(22);

        User user2 = new User();
        user2.setName("mike");
        user2.setAge(23);

        List<User> userlist = new ArrayList<>();
        userlist.add(user);
        userlist.add(user2);
        return userlist;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}