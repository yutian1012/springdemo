package spittr.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query("select p from Spitter as p where p.username=:username")
	Spitter findSpitterByUsernameParamName(@Param("username")String username);
	
	@Query("select p from Spitter as p where p.username in (?1)")
	List<Spitter> findSpitterListByUserName(List<String> username);
	
	@Query("select p.username from Spitter as p ")
	List<Object> findUserNameList();
	
	@Query("select p.id,p.username from Spitter as p ")
	List<Object[]> findUserNameAndIdList();

}
