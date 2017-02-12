package beachJudge.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beachJudge.services.UsersService;

@Service
public class BackendBean implements Backend {

	@Autowired
	UsersService userService;
}
