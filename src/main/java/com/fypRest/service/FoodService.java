package com.fypRest.service;

import com.fypRest.DAO.FoodRepository;
import com.fypRest.enitity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService
{
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository)
    {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods()
    {
        List<Food> foodList = foodRepository.findAll();
        return foodList;
    }

    public void save(Food food)
    {
        foodRepository.save(food);
    }

    public Food findById(int id)
    {
        Food newFood =null;
        Optional<Food> patient = foodRepository.findById(id);
        if(patient.isPresent())
        {
            newFood = patient.get();
        }
        return newFood;
    }

    public void deleteById(int id)
    {
        Food food = this.findById(id);
        foodRepository.delete(food);
        //foodRepository.deleteById(id);
    }

}
