package com.fypRest.Controller;

import com.EmailSender.EmailSender;
import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import com.EmailSender.service.EmailService;
import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.User;
import com.fypRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private EmailService service;
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
    public String newUser(@RequestBody User theUser)
    {
        userService.save(theUser);
        EmailSender emailSender = new EmailSender();
        MailRequest request = new MailRequest("Charity App", theUser.getEmail(), "charity.application501@gmail.com","Confirmation Email");
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Islamabad, Pakistan");
        MailResponse response = service.sendEmail(request, model);
        return response.getMessage();
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
