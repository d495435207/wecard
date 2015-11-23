package com.dxj.wecard.service;

import java.util.List;

import com.dxj.wecard.model.User;

public interface UserService {

	int delete(String id);

	int insert(User record);

	User getById(String id);

	int update(User record);

	List<User> getAll();

	void putUserCache(User record);

	User getUserCache(String id);
}