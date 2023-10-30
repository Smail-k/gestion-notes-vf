package com.polytech.notes.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Mobilite {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pays; 
	private String description; 
	
	

}
