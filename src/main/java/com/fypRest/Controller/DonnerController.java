package com.fypRest.Controller;

import com.fypRest.DAO.DonnerRepository;
import com.fypRest.enitity.Donner;
import com.fypRest.service.DonnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/donners")
public class DonnerController
{
    @Autowired
    private DonnerService donnerService;
    @Autowired
    private DonnerRepository donnerRepository;

    @GetMapping("/list")
    public Page<Donner> getDonners(@RequestParam Optional<Integer> page)
    {
        return donnerRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newDonner")
    public Donner newDonner(@RequestBody Donner theDonner)
    {
        System.out.println(theDonner);
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
