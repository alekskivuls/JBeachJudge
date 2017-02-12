package beachJudge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.vaadin.spring.security.annotation.EnableVaadinManagedSecurity;
import org.vaadin.spring.security.config.AuthenticationManagerConfigurer;

import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;

import beachJudge.models.Role;
import beachJudge.models.User;
import beachJudge.repositories.UserRepository;
import beachJudge.services.UsersDetailService;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
@EnableVaadinManagedSecurity
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println();
	}

	/**
	 * Provide custom system messages to make sure the application is reloaded
	 * when the session expires.
	 */
	@Bean
	SystemMessagesProvider systemMessagesProvider() {
		return new SystemMessagesProvider() {
			@Override
			public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
				CustomizedSystemMessages systemMessages = new CustomizedSystemMessages();
				systemMessages.setSessionExpiredNotificationEnabled(false);
				return systemMessages;
			}
		};
	}

	/**
	 * Configure the authentication manager.
	 */
	@Configuration
	static class AuthenticationConfiguration implements AuthenticationManagerConfigurer {

		@Autowired
		private UsersDetailService users;

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(users);
		}
	}

	/**
	 * Insert data in the database for development purposes
	 */
	@Bean
	public CommandLineRunner loadData(UserRepository repository) {
		return (args) -> {
			User regular = new User("user", "password", "first", "last", Role.USER);
			repository.save(regular);
			User admin = new User("admin", "password", "first", "last", Role.ADMIN);
			repository.save(admin);

			// fetch all users
			for (User user : repository.findAll()) {
				System.out.println(user.toString());
			}
			System.out.println();

		};
	}

}
