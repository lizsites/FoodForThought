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
@Table(name = "users")
public class User {

//	public enum UserDiet {
//        GLUTEN_FREE,
//        VEGAN, 
//		  VEGETARIAN, 
//etc. add the rest of the diets here
//
//    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "user_name", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "min_calories")
	private int minCalories;

	@Column(name = "max_calories")
	private int maxCalories;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Recipe> recipes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Picture> pictures;

	@Enumerated(EnumType.STRING)
	// @Column(name="user_diet", nullable=false)
	private Diet diet;

	public User(int id, String username, String password, int minCalories, int maxCalories, List<Recipe> recipes,
			List<Picture> pictures, Diet diet) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.minCalories = minCalories;
		this.maxCalories = maxCalories;
		this.recipes = recipes;
		this.pictures = pictures;
		this.diet = diet;
	}

	public User(String username, String password, int minCalories, int maxCalories, List<Recipe> recipes,
			List<Picture> pictures, Diet diet) {
		super();
		this.username = username;
		this.password = password;
		this.minCalories = minCalories;
		this.maxCalories = maxCalories;
		this.recipes = recipes;
		this.pictures = pictures;
		this.diet = diet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diet == null) ? 0 : diet.hashCode());
		result = prime * result + id;
		result = prime * result + maxCalories;
		result = prime * result + minCalories;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pictures == null) ? 0 : pictures.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
		if (diet != other.diet)
			return false;
		if (id != other.id)
			return false;
		if (maxCalories != other.maxCalories)
			return false;
		if (minCalories != other.minCalories)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pictures == null) {
			if (other.pictures != null)
				return false;
		} else if (!pictures.equals(other.pictures))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", minCalories=" + minCalories
				+ ", maxCalories=" + maxCalories + ", recipes=" + recipes + ", diet=" + diet + "]";
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
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

}
