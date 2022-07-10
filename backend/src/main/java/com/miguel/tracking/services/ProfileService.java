package com.miguel.tracking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.tracking.models.Profile;
import com.miguel.tracking.repositories.ProfileRepo;

@Service
public class ProfileService {
	
	private ProfileRepo pr;
	
	@Autowired
	public ProfileService(ProfileRepo pr) {
		this.pr = pr;
	}//end constructor
	
	public Profile login(String username, String password) {
		
		if(username == null || password == null || username.isEmpty() || password.isEmpty()) {
			return null;
		}
		
		Profile profile = pr.getProfileByUsername(username);
		
		if(profile != null && profile.getPassword().equals(username)) {
			return profile;
		}else {
			return null;
		}
		
	}//end login function
	
}//end ProfileService class
