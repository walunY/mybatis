package xyz.walun.dao;

import xyz.walun.domain.Account;
import xyz.walun.domain.UserAccount;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有的账户信息,以及用户信息 一对一 一个账户对应一个用户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有的账户信息和用户信息
     * @return
     */
    List<UserAccount> findAllAccount();

    /**
     * 根据uid查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountById(Integer uid);
}
