package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Enumerated(EnumType.ORDINAL)
	private Diet diet;

	public User(int id, String username, String password, int minCalories, int maxCalories, Diet diet) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.minCalories = minCalories;
		MaxCalories = maxCalories;
		this.diet = diet;
	}
	
	

	public User(String username, String password, int minCalories, int maxCalories, Diet diet) {
		super();
		this.username = username;
		this.password = password;
		this.minCalories = minCalories;
		MaxCalories = maxCalories;
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

	@Column(name="min_calories")
	private int minCalories;
	
	@Column(name="max_calories")
	private int MaxCalories;
	
	
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
		return MaxCalories;
	}

	public void setMaxCalories(int maxCalories) {
		MaxCalories = maxCalories;
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
				+ ", MaxCalories=" + MaxCalories + ", diet=" + diet + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MaxCalories;
		result = prime * result + ((diet == null) ? 0 : diet.hashCode());
		result = prime * result + id;
		result = prime * result + minCalories;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
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
		if (MaxCalories != other.MaxCalories)
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
