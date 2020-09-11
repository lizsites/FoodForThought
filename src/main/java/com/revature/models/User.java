package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name" , unique = true)
	private String username;
	
	@Column(name="min_calories")
	private int minCalories;
	
	@Column(name="max_calories")
	private int MaxCalories;
	
	@Column(name="diet")
	private String diet;
	
	private enum Diet {
		Glutenfree, Paleo, keto
	}
	
	
}
