package com.fypRest.service;

import com.fypRest.DAO.FundRepository;
import com.fypRest.enitity.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundService
{
    @Autowired
    private FundRepository fundRepository;

    @Autowired
    public FundService(FundRepository fundRepository)
    {
        this.fundRepository = fundRepository;
    }

    public List<Fund> getAllFunds()
    {
        List<Fund> fundList = fundRepository.findAll();
        return fundList;
    }

    public void save(Fund fund)
    {
        fundRepository.save(fund);
    }

    public Fund findById(int id)
    {
        Fund newFund =null;
        Optional<Fund> patient = fundRepository.findById(id);
        if(patient.isPresent())
        {
            newFund = patient.get();
        }
        return newFund;
    }

    public void deleteById(int id)
    {
        Fund fund = this.findById(id);
        fundRepository.delete(fund);
        //fundRepository.deleteById(id);
    }

}
