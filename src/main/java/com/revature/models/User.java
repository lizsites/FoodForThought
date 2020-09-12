package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="user_name" , unique = true)
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="min_calories")
	private int minCalories;
	
	@Column(name="max_calories")
	private int maxCalories;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="owner", cascade = CascadeType.ALL)
	private List<Recipe> recipes;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user", cascade = CascadeType.ALL)
	private List<Picture> pictures;
	
	@Enumerated(EnumType.STRING)
	private Diet diet;

	public User(int id, String username, String password, int minCalories, int maxCalories, Diet diet) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.minCalories = minCalories;
		this.maxCalories = maxCalories;
		this.diet = diet;
	}	

	public User(String username, String password, int minCalories, int maxCalories, Diet diet) {
		super();
		this.username = username;
		this.password = password;
		this.minCalories = minCalories;
		this.maxCalories = maxCalories;
		this.diet = diet;
	}


	public User() {
		super();
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMinCalories() {
		return minCalories;
	}

	public void setMinCalories(int minCalories) {
		this.minCalories = minCalories;
	}

	public int getMaxCalories() {
		return maxCalories;
	}

	public void setMaxCalories(int maxCalories) {
		this.maxCalories = maxCalories;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", minCalories=" + minCalories
				+ ", MaxCalories=" + maxCalories + ", diet=" + diet + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (this.maxCalories != other.maxCalories)
			return false;
		if (diet != other.diet)
			return false;
		if (id != other.id)
			return false;
		if (minCalories != other.minCalories)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
