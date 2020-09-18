package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Recipe;

@Repository
@Transactional
public class RecipeDAOImp implements RecipeDAO {

	private SessionFactory sf;
	
	@Autowired
	public RecipeDAOImp(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public boolean addRecipe(Recipe r) {
		Session sess = sf.getCurrentSession();
		if(r!=null) {
			sess.save(r);
			return true;
		}else
			return false;
			
	}

	@Override
	public boolean updateRecipe(Recipe r) {
		Session sess = sf.getCurrentSession();
		if(r!=null) {
			sess.update(r);
			return true;
		}else
			return false;
	}

	@Override
	public boolean deleteRecipe(int id) {
		Session sess = sf.getCurrentSession();
		if(id>0) {
			sess.delete(id);
			return true;
		}else
			return false;
	}

	@Override
	public Recipe getById(int id) {
		Session sess = sf.getCurrentSession();
		return sess.get(Recipe.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getByTitle(String title) {
		Session sess = sf.getCurrentSession();
		Query<Recipe> q = sess.createQuery("FROM recipe WHERE title = :title");
		q.setParameter("title", title);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllByUserId(int id) {
		Session sess = sf.getCurrentSession();
		Query<Recipe> q = sess.createQuery("FROM recipe WHERE owner.id = :id");
		q.setParameter("id", id);
		return q.list();
	}
}
