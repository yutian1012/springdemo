package spittr.db;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpitterRepositoryTest {

	@Autowired
	SpitterRepository spitterRepository;
	
	@Test
	@Transactional
	public void testSave() {
		Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
		spitterRepository.save(spitter);
		assertEquals(1, spitterRepository.count());
	}
	
	@Test
	@Transactional
	public void testSelectSingleField() {
		Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
		spitterRepository.save(spitter);
		Spitter spitter2 = new Spitter(null, "newbee2", "letmein2", "New Bee2", "newbee2@habuma.com", true);
		spitterRepository.save(spitter2);
		List<Object> result=spitterRepository.findUserNameList();
		assertNotNull(result);
		assertEquals(2, result.size());
	}
	
	@Test
	@Transactional
	public void testSelectFieldWithId() {
		Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
		spitterRepository.save(spitter);
		Spitter spitter2 = new Spitter(null, "newbee2", "letmein2", "New Bee2", "newbee2@habuma.com", true);
		spitterRepository.save(spitter2);
		List<Object[]> result=spitterRepository.findUserNameAndIdList();
		assertNotNull(result);
		assertEquals(2, result.size());
		for(Object[] s:result) {
			System.out.println(s[1]);//输出username
		}
	}

}
