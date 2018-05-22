package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;

import spittr.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByName(String name);
}
