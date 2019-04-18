package xyz.walun.dao;

import xyz.walun.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息并获得其账户信息 一对多 一个用户对应多个账号
     * @return
     */
    List<User> findAll();

    User findById(Integer userId);
}
