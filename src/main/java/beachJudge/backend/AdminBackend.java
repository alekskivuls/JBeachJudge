
package beachJudge.backend;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import beachJudge.models.User;

public interface AdminBackend {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void createAccount(User user);
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<User> getAllUser();
	
}
