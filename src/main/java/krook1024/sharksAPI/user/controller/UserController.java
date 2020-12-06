package krook1024.sharksAPI.user.controller;

import krook1024.sharksAPI.user.model.User;
import krook1024.sharksAPI.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/{name}")
    public User getOne(@PathVariable String name) {
        return userService.findByUsername(name);
    }

    @PostMapping("/user/register")
    public User saveOne(@RequestBody User user) {
        return userService.saveOne(user);
    }
}
