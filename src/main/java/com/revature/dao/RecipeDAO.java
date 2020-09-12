package com.revature.dao;

import java.util.List;

import com.revature.models.Recipe;

public interface RecipeDAO {
	public boolean addRecipe(Recipe r);
	public boolean updateRecipe(Recipe r);
	public boolean deleteRecipe(int id);
	public Recipe getById(int id);
	public List<Recipe> getByTitle(String title);
	public List<Recipe> getAllByUserId(int id);
}
