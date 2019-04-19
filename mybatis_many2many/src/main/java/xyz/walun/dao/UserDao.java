package xyz.walun.dao;

import xyz.walun.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息并获得其账户信息多对多 多个用户对应多个角色
     * @return
     */
    List<User> findAll();

    User findById(Integer userId);
}
