package xyz.walun.dao;

import xyz.walun.domain.QueryVo;
import xyz.walun.domain.User;

import java.util.List;

public interface UserDao {
	List<User> findAll();

	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * 更新用户操作
	 * @param user
	 */
	void updateUser(User user);

	void deleteUser(Integer userId);

	User findById(Integer userId);

	List<User> findByName(String name);

	int findTotal();
	/**
	 * 根据queryVo中的条件查询用户
	 * @param vo
	 * @return
	 */
	List<User> findUserByVo(QueryVo vo);
}
