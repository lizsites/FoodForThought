package com.revature.dao;

import java.util.List;

import com.revature.models.Preferences;
import com.revature.models.User;

public interface PreferencesDAO {
	public boolean addPreference(Preferences p);
	public boolean updatePreference(Preferences p);
	public Preferences getById(int id);
	public Preferences getByUserId(int id);
	public List<User> getUsersByPreferenceId(int id);
}
