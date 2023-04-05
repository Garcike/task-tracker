package com.miguel.tracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miguel.tracking.models.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer>{
	
	Profile getProfileByUsername(String username);
	
}//end interface
