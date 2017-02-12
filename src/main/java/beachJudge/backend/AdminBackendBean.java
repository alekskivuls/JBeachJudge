
package beachJudge.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beachJudge.models.User;
import beachJudge.services.UsersService;

/**
 * Implementation of {@link beachJudge.backend.AdminBackend}.
 */
@Service
public class AdminBackendBean implements AdminBackend {
	
	@Autowired
	UsersService usersService;

	@Override
	public void createUser(User user) {
		usersService.createUser(user);
	}
	
	@Override
	public List<User> getAllUser(){
		return usersService.getAllUser();
	}

	@Override
	public void deleteAccount(User user) {
		usersService.deleteUser(user);
	}

	@Override
	public User getCurrentUser() {
		return usersService.getCurrentUser();
	}
}
