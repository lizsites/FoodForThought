package com.revature.dao;

import com.revature.models.Recipe;

public interface RecipeDAO {
	public boolean addRecipe(Recipe r);
	public boolean updateRecipe(Recipe r);
	public Recipe getById(int id);
}
