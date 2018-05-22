package spittr.db;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

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
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	@Test
	@Transactional
	public void testSave() {
		Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        Account account=new Account(null,"zhangsan",80000,null);
        
        User u=new User(null,"aa1", "aa123456", "aa@126.com", "aa",formattedDate,account,null);
        account.setUser(u);
        
        userRepository.save(u);
        
        User u2=userRepository.findByUserName("aa1");
        
        assertNotNull(u2);
        
        assertTrue(u.getId().longValue()==u2.getId().longValue());
        
        System.out.println(u2.getAccount().getName());
	}
	
	@Test
	public void testSearch() {
		
	}

}
