package com.fypRest.DAO;

import com.fypRest.enitity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Integer>
{
}
