package xyz.walun.dao;

import xyz.walun.domain.User;

import java.util.List;

public interface UserDao {
	List<User> findAll();
}
