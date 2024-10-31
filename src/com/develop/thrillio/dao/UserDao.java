package com.develop.thrillio.dao;

import com.develop.thrillio.DataStore;
import com.develop.thrillio.entities.User;

public class UserDao {
	public User[] getUsers() {
		return DataStore.getUsers();
	}
}