package com.fypRest.Controller;

import com.fypRest.DAO.DonationRepository;
import com.fypRest.enitity.Donation;
import com.fypRest.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/donations")
public class DonationController
{
    @Autowired
    private DonationService donationService;
    @Autowired
    private DonationRepository donationRepository;

    @GetMapping("/list")
    public Page<Donation> getDonations(@RequestParam Optional<Integer> page)
    {
        return donationRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newDonation")
    public Donation newDonation(@RequestBody Donation theDonation)
    {
        System.out.println(theDonation);
        donationService.save(theDonation);
        System.out.println(theDonation);
        return theDonation;
    }
    @PutMapping("/updateDonation")
    public Donation updateDonation(@RequestBody Donation theDonation)
    {
        System.out.println(theDonation);
        donationService.save(theDonation);
        System.out.println(theDonation);
        return theDonation;
    }
    @DeleteMapping("/deleteDonation/{donationId}")
    public String deleteDonation(@PathVariable int donationId)
    {
        donationService.deleteById(donationId);
        return "Donation id - " + donationId + " is deleted.";
    }
}
