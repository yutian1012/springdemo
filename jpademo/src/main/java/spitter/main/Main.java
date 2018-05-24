package spitter.main;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spitter.config.JpaConfig;
import spitter.service.AddressService;
import spitter.service.UserService;
import spittr.domain.Address;
import spittr.domain.User;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JpaConfig.class);
		
		UserService userService=applicationContext.getBean(UserService.class);
		
		AddressService addressService=applicationContext.getBean(AddressService.class);
		
		Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
        String formattedDate = dateFormat.format(date);
        
		User user=new User();
		user.setUserName("test");
		user.setRegTime(formattedDate);
		user.setNickName("t");
		user.setPassWord("xxxxx");
		user.setEmail("test@qq.com");
		
		userService.addUser(user);//先注册用户完成
		
		//用户填写地址1
		Address address=new Address(null, "北京海淀区", "10000", "北京",user);
		
		addressService.add(address);
		
		Long addressId=address.getId();
		
		//用户填写地址2
		Address address2=new Address(null, "北京海淀区2", "10002", "北京2",user);
		
		addressService.add(address2);
		
		//从数据库中加载用户
		User dbUser=userService.findByUsername("test");
		
		//assert 2==dbUser.getAddressList().size();
		System.out.println(dbUser.getAddressList().size());
		
		//获取地址，并判断关联用户
		Address add=addressService.findById(addressId);
		
		//assert "test".equals(add.getUser().getUserName());
		System.out.println("test".equals(add.getUser().getUserName()));
	}
}
