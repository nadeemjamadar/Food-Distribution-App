package com.fypRest.DAO;

import com.fypRest.enitity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>
{
}
