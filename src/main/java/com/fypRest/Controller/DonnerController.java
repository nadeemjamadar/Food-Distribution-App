package com.fypRest.Controller;

import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import com.EmailSender.service.EmailService;
import com.fypRest.DAO.DonnerRepository;
import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.Donner;
import com.fypRest.enitity.User;
import com.fypRest.service.DonnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/donners")
public class DonnerController
{
    @Autowired
    private EmailService service;

    @Autowired
    private DonnerService donnerService;
    @Autowired
    private DonnerRepository donnerRepository;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/list")
    public Page<Donner> getDonners(@RequestParam Optional<Integer> page)
    {
        return donnerRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newDonner")
    public Donner newDonner(@RequestBody Donner theDonner)
    {
        System.out.println(theDonner);
        User u = theDonner.getUser();
        System.out.println(u);
        MailRequest request = new MailRequest("Charity App", u.getEmail(), "charity.application501@gmail.com", "Confirmation Email");
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Islamabad, Pakistan");
        MailResponse response = service.sendEmail(request, model);
        String responce =  response.getMessage();
        System.out.println(responce);
        donnerService.save(theDonner);
        System.out.println(theDonner);
        return theDonner;
    }

    @PutMapping("/updateDonner")
    public Donner updateDonner(@RequestBody Donner theDonner)
    {
        System.out.println(theDonner);
        donnerService.save(theDonner);
        System.out.println(theDonner);
        return theDonner;
    }
    @DeleteMapping("/deleteDonner/{donnerId}")
    public String deleteDonner(@PathVariable int donnerId)
    {
        donnerService.deleteById(donnerId);
        return "Donner id - " + donnerId + " is deleted.";
    }
}
