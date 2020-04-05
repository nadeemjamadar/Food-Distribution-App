package com.fypRest.Controller;

import com.fypRest.DAO.FoodRepository;
import com.fypRest.enitity.Food;
import com.fypRest.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/foods")
public class FoodController
{
    @Autowired
    FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/list")
    public Page<Food> getFoods(@RequestParam Optional<Integer> page)
    {
        return foodRepository.findAll(PageRequest.of(page.orElse(0), 5));
    }

    @PostMapping("/newFood")
    public Food newFood(@RequestBody Food theFood)
    {
        try
        {
            System.out.println(theFood);
            foodService.save(theFood);

            return theFood;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return theFood;
    }

    @PutMapping("/updateFood")
    public Food updateFood(@RequestBody Food theFood)
    {
        foodService.save(theFood);
        return theFood;
    }

    @DeleteMapping("/deleteFood/{foodId}")
    public String deleteFood(@PathVariable int foodId)
    {
        foodService.deleteById(foodId);
        return "Food id - " + foodId + " is deleted.";
    }
}
