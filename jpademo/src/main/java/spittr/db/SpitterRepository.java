package spittr.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spittr.domain.Spitter;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> ,SpitterExtentionRepository{
	  
	Spitter findByUsername(String username);
	
	List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);
	
	@Query("select p from Spitter as p where p.username=?1")
	Spitter findSpitterByUsernameInfo(String username);

}
