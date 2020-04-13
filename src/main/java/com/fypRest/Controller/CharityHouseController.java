package com.fypRest.Controller;

import com.fypRest.DAO.CharityHouseRepository;
import com.fypRest.enitity.CharityHouse;
import com.fypRest.service.CharityHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/charityHouses")
public class CharityHouseController
{
    @Autowired
    private CharityHouseService charityHouseService;

    @Autowired
    private CharityHouseRepository charityHouseRepository;

    @GetMapping("/list")
    public Page<CharityHouse> getCharityHouses(@RequestParam Optional<Integer> page)
    {
        return charityHouseRepository.findAll(PageRequest.of(page.orElse(0), 5));
    }

    @PostMapping("/newCharityHouse")
    public CharityHouse newCharityHouse(@RequestBody CharityHouse theCharityHouse)
    {
        System.out.println(theCharityHouse);
        charityHouseService.save(theCharityHouse);
        return theCharityHouse;
    }

    @GetMapping("/getCharityHouse/{charityHouseId}")
    public Optional<CharityHouse> getUsersById(@PathVariable int charityHouseId) throws ResourceNotFoundException
    {
        return charityHouseRepository.findById(charityHouseId);
    }

    @PutMapping("/updateCharityHouse")
    public CharityHouse updateCharityHouse(@RequestBody CharityHouse theCharityHouse)
    {
        charityHouseService.save(theCharityHouse);
        return theCharityHouse;
    }

    @DeleteMapping("/deleteCharityHouse/{charityHouseId}")
    public String deleteCharityHouse(@PathVariable int charityHouseId)
    {
        charityHouseService.deleteById(charityHouseId);
        return "User id - " + charityHouseId + " is deleted.";
    }
}
