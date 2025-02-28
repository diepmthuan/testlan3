package poly.edu.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.edu.dao.AccountDAO;
import poly.edu.entity.AccountEntity;
import poly.edu.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired  
	AccountDAO accountDAO;

	@Override
	public AccountEntity findByUsername(String username) {
		return accountDAO.findByUsername(username).orElse(null);
	}

	@Override
	public AccountEntity findById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(AccountEntity account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
