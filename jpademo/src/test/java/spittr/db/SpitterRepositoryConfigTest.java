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
public class SpitterRepositoryConfigTest {

	@Autowired
	SpitterRepository spitterRepository;
	
	@Test
	@Transactional
	public void testSave() {
		Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee", "newbee@habuma.com", true);
		spitterRepository.save(spitter);
		assertEquals(1, spitterRepository.count());
	}

}
