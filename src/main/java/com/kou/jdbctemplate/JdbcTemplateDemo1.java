package com.kou.jdbctemplate;
import com.kou.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author JIAJUN KOU
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("jdbcConfig.xml");
        JdbcTemplate template = ac.getBean("jdbcTemplate",JdbcTemplate.class);

        String sql="select * from account";
        List<Account> accounts = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        for (Account account : accounts) {
            System.out.println(account);
        }


    }
}
