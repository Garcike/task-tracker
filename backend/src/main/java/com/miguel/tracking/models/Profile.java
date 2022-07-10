package com.miguel.tracking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "profile")
/*
 * @Data generates all the boilerplate that is normally associated with
 * simple POJOs and beans: getters for all fields, setters for all
 * non-final fields, and appropriate toString, equals and hashCode
 */
@Data

/*
 * Maybe exclude some fields
 */

public class Profile {

	@Id
	@Column(name = "profile_id")
	private int pid;
	
	@Column(unique = true, nullable= false)
	private String username;
	
	@Column(nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	/*
	 * Access setting that means that the property may only be written
	 * (set) for deserialization, but will not be read (get) on serialization.
	 * The value of the property is not included in serialization
	 */
	private String password;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	public Profile() {
		super();
	
	}//end constructor
	
	
}//end profile class
