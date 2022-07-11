package com.miguel.tracking.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguel.tracking.exceptions.AuthenticationException;
import com.miguel.tracking.exceptions.ProfileAlreadyExistException;
import com.miguel.tracking.exceptions.ProfileNotFoundException;
import com.miguel.tracking.models.Profile;
import com.miguel.tracking.repositories.ProfileRepo;

@Service
public class ProfileService {
	
	private ProfileRepo pr;
	
	private static Logger log =LoggerFactory.getLogger(ProfileService.class);
	
	@Autowired
	public ProfileService(ProfileRepo pr) {
		this.pr = pr;
	}//end constructor
	
	/**
	 * Processes login request
	 * @param username
	 * @param password
	 * @return profile
	 */
	public Profile login(String username, String password) {
		
		log.debug("Attempting to login");
		
		if(username == null || password == null || username.isEmpty() || password.isEmpty()) {
			throw new AuthenticationException("username or email not provided");
		}//end if
		
		Profile profile = pr.getProfileByUsername(username);
		
		if(profile == null) {
			throw new AuthenticationException("could not find profile with username: " + username);
		}//end if
		
		//add some security later
		if(!profile.getPassword().equals(username)) {
			throw new AuthenticationException("incorrect password");
		}//end if
		
		log.debug("Successfully logged in");
		
		return profile;
		
	}//end login function
	
	/**
	 * Creates new profile and add profile to database
	 * @param newProfile
	 * @return
	 */
	public Profile createProfile(Profile newProfile){
		
		log.debug("Attempting to create a new profile");
		
		//check it Profile already exists
		Profile profile = pr.getProfileByUsername(newProfile.getUsername());
		
		if(profile != null) {
			throw new ProfileAlreadyExistException("Profile with username already exists: " + newProfile.getUsername());
		}//end
		
		log.debug("Successfully created a new profile");
		
		return pr.save(newProfile);
		
		
	}//end createProfile
	
	/**
	 * Return profile by profile id
	 * @param pid
	 * @return Profile
	 */
	public Profile getProfileByPid(int pid) {
		
		Profile profile = pr.findById(pid).orElseThrow(()-> new ProfileNotFoundException("Profile not found"));
		
		return profile;
	
	}//end getProfielbyPid
	
	
}//end ProfileService class
