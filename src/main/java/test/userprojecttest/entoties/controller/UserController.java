package test.userprojecttest.entoties.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import test.userprojecttest.entoties.User;
import test.userprojecttest.repository.UserRepo;
import test.userprojecttest.service.UserService;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable long id,
            @RequestBody User user){
       return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

    @GetMapping
    public Page<User> getAllUsers(
            @RequestParam int pageNumber,
            @RequestParam int pageSize
    ) {
    return userService.getAllUsers(pageNumber, pageSize);
    }


}
