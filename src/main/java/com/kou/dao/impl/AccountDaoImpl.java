package com.kou.dao.impl;

import com.kou.dao.IAccountDao;
import com.kou.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class AccountDaoImpl implements IAccountDao{

    private JdbcTemplate template;
    //生成set方法 用spring自己注入对象
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    public Account findAccountById(Integer accountId) {
        String sql="select * from account where id=?";
        List<Account> accounts=template.query(sql,new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void updateAccount(Account account) {
        String sql="update account set name=?,money=? where id=?";
        template.update(sql,account.getName(),account.getMoney(),account.getId());

    }
}
