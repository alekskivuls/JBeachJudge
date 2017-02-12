package beachJudge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.spring.security.VaadinSecurity;

import beachJudge.models.User;
import beachJudge.repositories.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository repo;

	@Autowired
	VaadinSecurity vaadinSecurity;

	public User getUser(String userName) {
		return repo.findByUserName(userName);
	}

	public void createUser(User user) {
		repo.save(user);
	}
	
	public void deleteUser(User user) {
		repo.delete(user);
	}
	
	public List<User> getAllUser(){
		repo.findAll();
		return repo.findAll();
	}
	
	public User getCurrentUser() {
		String userName = vaadinSecurity.getAuthentication().getName();
		return getUser(userName);
	}
}
