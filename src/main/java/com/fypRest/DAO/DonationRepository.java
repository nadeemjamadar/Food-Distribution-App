package com.fypRest.DAO;

import com.fypRest.enitity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Integer>
{
}
