package com.fypRest.DAO;

import com.fypRest.enitity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>
{
    //@Query(value = "SELECT * FROM food where charity_house_id=?1", nativeQuery = true)
    //public List<Food> findBy(String id);
}
