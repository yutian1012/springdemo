package spittr.db;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Account;
import spittr.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	@Transactional
	public void test() {
		Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        //user对象设置account为null
        User u=new User(null,"aa1", "aa123456", "aa@126.com", "aa",formattedDate,null,null);
        
        //关联上User对象
		Account account=new Account(null,"zhangsan",80000,u);
		
		//保存外键字段
		u.setAccount(account);
		
        accountRepository.save(account);
        
        Account account2=accountRepository.findByName("zhangsan");
        
        assertNotNull(account2);
        
        System.out.println(account2.getUser().getEmail());
	}
}
