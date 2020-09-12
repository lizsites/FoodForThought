package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	int id;
	@Column(name="ingredient_name")
	String name;
	
	@Column(name="ingredient_protein")
	double protein;
	
	@Column(name="ingredient_cals")
	int cals;
	
	@ManyToMany(mappedBy = "ingredients")
	List<Recipe> recipes;

	public Ingredient(int id, String name, double protein, int cals, List<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.protein = protein;
		this.cals = cals;
		this.recipes = recipes;
	}

	public Ingredient(String name, double protein, int cals, List<Recipe> recipes) {
		super();
		this.name = name;
		this.protein = protein;
		this.cals = cals;
		this.recipes = recipes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public int getCals() {
		return cals;
	}

	public void setCals(int cals) {
		this.cals = cals;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
