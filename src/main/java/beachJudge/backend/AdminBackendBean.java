
package beachJudge.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import beachJudge.models.User;
import beachJudge.repositories.UserRepository;

/**
 * Implementation of {@link beachJudge.backend.AdminBackend}.
 */
@Service
public class AdminBackendBean implements AdminBackend {

	@Autowired
	UserRepository userRepo;

	@Override
	public void createAccount(User user) {
		userRepo.save(user);
	}
	
	@Override
	public List<User> getAllUser(){
		userRepo.findAll();
		return userRepo.findAll();
	}
}
