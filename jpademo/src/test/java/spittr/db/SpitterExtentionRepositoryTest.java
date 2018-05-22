package spittr.db;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import spittr.domain.Spitter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class)
public class SpitterExtentionRepositoryTest {

	@Autowired
	SpitterRepository spitterRepository;
	
	@Test
	@Transactional
	public void testSave() {
		Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@Gmail.com", true);
		spitterRepository.save(spitter);
		Spitter spitter2=spitterRepository.getSpitterByGmail("newbee@Gmail.com");
		assertNotNull(spitter);
		assertTrue(spitter.getId().longValue()==spitter2.getId());
	}
}
