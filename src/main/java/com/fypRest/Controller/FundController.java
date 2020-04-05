package com.fypRest.Controller;

import com.fypRest.DAO.FundRepository;
import com.fypRest.enitity.Fund;
import com.fypRest.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/funds")
public class FundController
{
    @Autowired
    FundService fundService;

    @Autowired
    private FundRepository fundRepository;
    @GetMapping("/list")
    public Page<Fund> getFunds(@RequestParam Optional<Integer> page)
    {
        return fundRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newFund")
    public Fund newFund(@RequestBody Fund theFund)
    {
        fundService.save(theFund);
        return theFund;
    }
    @PutMapping("/updateFund")
    public Fund updateFund(@RequestBody Fund theFund)
    {
        fundService.save(theFund);
        return theFund;
    }
    @DeleteMapping("/deleteFund/{fundId}")
    public String deleteFund(@PathVariable int fundId)
    {
        fundService.deleteById(fundId);
        return "Fund id - " + fundId + " is deleted.";
    }
}
