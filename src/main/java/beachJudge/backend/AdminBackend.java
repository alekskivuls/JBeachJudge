
package beachJudge.backend;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import beachJudge.models.User;

public interface AdminBackend {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void createUser(User user);

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	List<User> getAllUser();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void deleteAccount(User user);

}
