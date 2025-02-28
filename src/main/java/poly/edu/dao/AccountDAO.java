package poly.edu.dao;

import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.edu.entity.AccountEntity;
@Repository
public interface AccountDAO extends JpaRepository<AccountEntity, String>{
	Optional<AccountEntity> findByUsername(String username);
}
