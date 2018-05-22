package spittr.db;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Address;
import spittr.domain.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class AddressRepositoryTest {

	@Resource
	private AddressRepository addressRepository;
	
	@Resource
	private UserRepository userRepository;
	
	@Test
	@Transactional
	public void testSave() {
		Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        
		User user=new User();
		user.setUserName("test");
		user.setRegTime(formattedDate);
		user.setNickName("t");
		user.setPassWord("xxxxx");
		user.setEmail("test@qq.com");
		
		userRepository.save(user);//先注册用户完成
		
		//用户填写地址1
		Address address=new Address(null, "北京海淀区", "10000", "北京",user);
		
		addressRepository.save(address);
		
		Long addressId=address.getId();
		
		//用户填写地址2
		Address address2=new Address(null, "北京海淀区2", "10002", "北京2",user);
		
		addressRepository.save(address2);
		
		//从数据库中加载用户
		User dbUser=userRepository.findByUserName("test");
		
		assertTrue(2==dbUser.getAddressList().size());
		
		//获取地址，并判断关联用户
		Address add=addressRepository.findOne(addressId);
		
		assertEquals("test", add.getUser().getUserName());
	}
}
