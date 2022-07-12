package com.miguel.tracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.tracking.models.Profile;
import com.miguel.tracking.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	private ProfileService ps;
	
	@Autowired
	public ProfileController(ProfileService ps) {
		this.ps = ps;
	}//end constructor
	

	@PostMapping("/login")
	public ResponseEntity<Profile> login(String username, String password){
		
		Profile profile = ps.login(username, password);
		
		return new ResponseEntity<>(profile, HttpStatus.ACCEPTED);
		
		
	}//end login
	
	@PostMapping("/register")
	public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
		
		Profile newProfile = ps.createProfile(profile);
		
		return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
		
	}//end createProfile
	
	@GetMapping("/{id}")
	public ResponseEntity<Profile> getProfileByPid(@PathVariable("id") int id){
		
		Profile profile = ps.getProfileByPid(id);
		
		return new ResponseEntity<>(profile, HttpStatus.ACCEPTED);
		
	}//end getProfileByPid
	
	/*
	 * Some methods to update and delete profile
	 */
	
}//end profileController
