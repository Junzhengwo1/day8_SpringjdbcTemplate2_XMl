package com.kou.test;

import com.kou.dao.IAccountDao;
import com.kou.dao.impl.AccountDaoImpl;
import com.kou.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JIAJUN KOU
 */
public class JdbcTemplateTest {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("jdbcConfig.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        account.setMoney(100000f);

        accountDao.updateAccount(account);
        System.out.println(account);


    }
}
