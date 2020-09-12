package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	private int id;
	@Column(name="ingredient_name")
	private String name;
	
	@Column(name="ingredient_protein")
	private double protein;
	
	@Column(name="ingredient_cals")
	private int cals;
	
	@OneToMany(mappedBy="ingredient_id", cascade = CascadeType.ALL)
	private List<RecipeIngredient> recipeIngredient;
	
	public Ingredient(int id, String name, double protein, int cals, List<RecipeIngredient> recipeIngredient) {
		super();
		this.id = id;
		this.name = name;
		this.protein = protein;
		this.cals = cals;
		this.recipeIngredient = recipeIngredient;
	}

	public Ingredient(String name, double protein, int cals, List<RecipeIngredient> recipeIngredient) {
		super();
		this.name = name;
		this.protein = protein;
		this.cals = cals;
		this.recipeIngredient = recipeIngredient;
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
	
	public List<RecipeIngredient> getRecipeIngredient() {
		return recipeIngredient;
	}

	public void setRecipeIngredient(List<RecipeIngredient> recipeIngredient) {
		this.recipeIngredient = recipeIngredient;
	}

}
