package com.kou.dao;

import com.kou.domain.Account;

/**
 * 账户持久层接口
 *
 * @author dell
 */
public interface IAccountDao {


    /**
     *
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
