package io.tearstar.herojourney.controller;

import io.tearstar.herojourney.model.user.User;
import io.tearstar.herojourney.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/HeroJourney/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    private User getUser(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/")
    private User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/")
    private boolean deleteUser(@RequestParam Long id){
        return userService.deleteUser(id);
    }
}
