package xyz.walun.dao;

import xyz.walun.domain.Role;

import java.util.List;

public interface RoleDao {
	// 查询所有角色，并得到该角色赋予了谁
	List<Role> findAll();
}
