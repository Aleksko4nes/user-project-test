package test.userprojecttest.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.userprojecttest.DTO.UserDto;
import test.userprojecttest.entities.User;
import test.userprojecttest.service.UserService;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


}
