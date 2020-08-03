package com.fypRest.service;

import com.fypRest.DAO.ChannelRepository;
import com.fypRest.enitity.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService
{
    @Autowired
    ChannelRepository repository;

    public ChannelService()
    {
    }

    public String saveIfDontExist(String name){
        boolean exist = repository.existsByName(name);
        if(exist){
            return "Already Exists";
        } else {
            Channel channel = new Channel(name);
            System.out.println(repository.save(channel));
            return "Channel was not exist, saved successfully";
        }
    }
}
