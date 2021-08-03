package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long > {
	
	Optional<AppUser> findByUserName (String userName);

}
