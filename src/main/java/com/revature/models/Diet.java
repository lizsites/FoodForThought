package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "diet")
public class Diet {

	public enum DietType {
		GLUTEN_FREE, VEGAN, VEGETARIAN, LACTO_VEGETARIAN, KETOGENIC, OVO_VEGETARIAN, PESCETARIAN, PALEO, PRIMAL, WHOLE30
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "user_diet")
	private DietType diettype;

	@Column(name = "min_calories")
	private int minCalories;

	@Column(name = "max_calories")
	private int maxCalories;

}
