package com.miguel.tracking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.tracking.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	private ProfileService ps;
	
	@Autowired
	public ProfileController(ProfileService ps) {
		this.ps = ps;
	}//end constructor
	
	
	
}//end profileController
