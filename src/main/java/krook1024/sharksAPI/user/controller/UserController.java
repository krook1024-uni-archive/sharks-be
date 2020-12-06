package krook1024.sharksAPI.user.controller;

import krook1024.sharksAPI.user.model.User;
import krook1024.sharksAPI.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public User saveOne(@RequestBody User user) {
        return userService.saveOne(user);
    }
}
