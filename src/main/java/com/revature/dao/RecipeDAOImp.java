package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Recipe;
import com.revature.utilities.HibernateUtil;

public class RecipeDAOImp implements RecipeDAO {

	@Override
	public boolean addRecipe(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;

		tx = sess.beginTransaction();
		try {
			sess.save(r);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public boolean updateRecipe(Recipe r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		tx = sess.beginTransaction();
		try {			
			sess.merge(r);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public boolean deleteRecipe(int id) {
		Session sess = HibernateUtil.getSession();
		Transaction tx;
		tx = sess.beginTransaction();
		try {
			Recipe r = getById(id);
			sess.delete(r);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			sess.close();
		}
	}

	@Override
	public Recipe getById(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			return sess.get(Recipe.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getByTitle(String title) {
		//(Nikki) I'm not sure about this method? Open to changes
		Session sess = HibernateUtil.getSession();
		try {
			return sess.createQuery("FROM recipes WHERE title = '"+title + "'").list();
		}catch (HibernateException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllByUserId(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			//not sure if will work
			return sess.createQuery("FROM recipes WHERE owner.id = "+ id).list();
		}catch (HibernateException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}	
	}
}
