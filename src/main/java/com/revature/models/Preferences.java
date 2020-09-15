package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {

	public enum DietType {
		GLUTEN_FREE, VEGAN, VEGETARIAN, LACTO_VEGETARIAN, KETOGENIC, OVO_VEGETARIAN, PESCETARIAN, PALEO, PRIMAL, WHOLE30
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_diet")
	private DietType dietType;

	@Column(name = "min_calories")
	private int minCalories;

	@Column(name = "max_calories")
	private int maxCalories;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public Preferences() {
		super();
	}

	public Preferences(DietType dietType, int minCalories, int maxCalories, User user) {
		super();
		this.dietType = dietType;
		this.minCalories = minCalories;
		this.maxCalories = maxCalories;
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dietType == null) ? 0 : dietType.hashCode());
		result = prime * result + maxCalories;
		result = prime * result + minCalories;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Preferences other = (Preferences) obj;
		if (dietType != other.dietType)
			return false;
		if (maxCalories != other.maxCalories)
			return false;
		if (minCalories != other.minCalories)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Preferences [dietType=" + dietType + ", minCalories=" + minCalories + ", maxCalories=" + maxCalories
				+ ", user=" + user + "]";
	}

	public DietType getDietType() {
		return dietType;
	}

	public void setDietType(DietType dietType) {
		this.dietType = dietType;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
