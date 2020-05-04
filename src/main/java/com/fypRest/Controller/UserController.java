package com.fypRest.Controller;

import com.EmailSender.GetTemplateWithURL;
import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import com.EmailSender.service.EmailService;
import com.fypRest.DAO.DonnerRepository;
import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.Donner;
import com.fypRest.enitity.User;
import com.fypRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private EmailService service;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonnerRepository donnerRepository;

    @GetMapping("/list")
    public Page<User> getUsers(@RequestParam Optional<Integer> page)
    {
        return userRepository.findAll(PageRequest.of(page.orElse(0), 5));
    }

    @GetMapping("/getUser/{userId}")
    public Optional<User> getUsersById(@PathVariable int userId) throws ResourceNotFoundException
    {
        return userRepository.findById(userId);
    }
    @PostMapping("/newUser")
    public User newUser(@RequestBody User theUser)
    {
        userService.save(theUser);
        MailRequest request = new MailRequest("Charity App", theUser.getEmail(), "charity.application501@gmail.com","Confirmation Email");
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Islamabad, Pakistan");
        MailResponse response = service.sendEmail(request, model);
        String responce =  response.getMessage();
        System.out.println(responce);
        return theUser;
    }

    @PostMapping("/login")
    public Response checkUsername(@RequestBody User user)
    {
        User u = userRepository.findByEmail(user.getEmail());
        System.out.println("user get by email. " + u);
        System.out.println("User coming from request body. " + user);
        Response response = new Response();
        if(u == null){
            response.setEmailStatus(false);
            response.setLoginStatus(false);
            response.setApplicationStatus("disapproved");
            return response;
        }
        else {
            if(user.getPassword().equals(u.getPassword()))
            {
                Donner donner = donnerRepository.findByUser(u.getId());
                response.setEmailStatus(true);
                response.setLoginStatus(true);
                response.setApplicationStatus(u.getApplicationStatus());
                System.out.println("donner id" + donner.getId());
                response.setUserID(donner.getId());
                System.out.println("response id" + response.getUserID());
                System.out.println(donner);
                return response;
            }
            else{
                response.setEmailStatus(true);
                response.setLoginStatus(false);
                response.setApplicationStatus(u.getApplicationStatus());
                return response;
            }
        }
    }

    @GetMapping("/email/{email}")
    public boolean checkEmailDuplication(@PathVariable("email") String email)
    {
        if(userRepository.findByEmail(email)!= null)
            return false;
        return true;
    }

    @PostMapping("/applicationStatus/{email}")
    public void setApplicationStatus(@PathVariable("email") String email)
    {
        User user = userRepository.findByEmail(email);
        if(user!= null)
            {
                user.setApplicationStatus("approved");
                userRepository.save(user);
            }
    }

    @GetMapping("/username/{username}")
    public boolean checkUsernameDuplication(@PathVariable String username)
    {
        System.out.println(userRepository.findByUsername(username));
        if(userRepository.findByUsername(username)!= null)
            return false;
        return true;
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
class Response{
    private boolean emailStatus;
    private boolean loginStatus;
    private String applicationStatus;
    private int userID;

    public Response()
    {
    }

    public Response(boolean emailStatus, boolean loginStatus,int userID)
    {
        this.emailStatus = emailStatus;
        this.loginStatus = loginStatus;
        this.userID = userID;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public boolean getEmailStatus()
    {
        return emailStatus;
    }

    public void setEmailStatus(boolean passwordStatus)
    {
        this.emailStatus = passwordStatus;
    }

    public boolean isEmailStatus()
    {
        return emailStatus;
    }

    public String getApplicationStatus()
    {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus)
    {
        this.applicationStatus = applicationStatus;
    }

    public boolean isLoginStatus()
    {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus)
    {
        this.loginStatus = loginStatus;
    }
}
