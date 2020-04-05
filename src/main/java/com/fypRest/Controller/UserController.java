package com.fypRest.Controller;

import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.User;
import com.fypRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/list")
    public Page<User> getUsers(@RequestParam Optional<Integer> page)
    {
        return userRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newUser")
    public User newUser(@RequestBody User theUser)
    {
        userService.save(theUser);
        return theUser;
    }
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User theUser)
    {
        userService.save(theUser);
        return theUser;
    }
    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId)
    {
        userService.deleteUser(userId);
        return "User id - " + userId + " is deleted.";
    }
}
