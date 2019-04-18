package xyz.walun.dao;

import xyz.walun.domain.Account;
import xyz.walun.domain.UserAccount;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有的账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有的账户信息和用户信息
     * @return
     */
    List<UserAccount> findAllAccount();
}
