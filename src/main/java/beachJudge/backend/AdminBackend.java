
package beachJudge.backend;

import org.springframework.security.access.prepost.PreAuthorize;

import beachJudge.models.User;

public interface AdminBackend {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void createAccount(User user);
}
