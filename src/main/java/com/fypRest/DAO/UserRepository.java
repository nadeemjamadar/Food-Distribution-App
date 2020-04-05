package com.fypRest.DAO;

import com.fypRest.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>
{
}
