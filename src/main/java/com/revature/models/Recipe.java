package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private int id;

	@Column(name="recipe_body")
	private String body;
	
	@Column(name="recipe_cals")
	private int cals;
	
	@Column(name="recipe_title", nullable=false)
	String title;
	
	@OneToMany(mappedBy="recipe", cascade = CascadeType.ALL)
	private List<RecipeIngredient> recipeIngredient;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User owner;
	
	public Recipe(String title, String body, int cals) {
		super();
		this.title = title;
		this.body = body;
		this.cals = cals;
	}

	public Recipe(int id, String title, String body, int cals) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.cals = cals;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (cals != other.cals)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getCals() {
		return cals;
	}

	public void setCals(int cals) {
		this.cals = cals;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", body=" + body + ", cals=" + cals + ", recipeIngredient=" + recipeIngredient
				+ ", owner=" + owner + ", title=" + title + "]";
	}
	
	
}
