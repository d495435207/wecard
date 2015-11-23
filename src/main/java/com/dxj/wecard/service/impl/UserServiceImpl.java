package com.dxj.wecard.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dxj.wecard.dao.UserMapper;
import com.dxj.wecard.model.User;
import com.dxj.wecard.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisTemplate<String, Serializable> redisTemplate;

	@Override
	public int delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public User getById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public void putUserCache(User record) {
		String key=this.getClass().getSimpleName()+"."+User.class.getSimpleName()+"."+record.getId();
		String value=JSON.toJSONString(record);
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public User getUserCache(String id) {
		String key=this.getClass().getSimpleName()+"."+User.class.getSimpleName()+"."+id;
		String value=(String)redisTemplate.opsForValue().get(key);
		return (User) JSON.parseObject(value,User.class);
	}
}