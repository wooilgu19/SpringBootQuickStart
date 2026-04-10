package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rubypaper.domain.Role;
import com.rubypaper.domain.User;
import com.rubypaper.persistence.UserRepository;

@SpringBootTest
public class PasswordEncodingTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Test
	public void testInsert() {
		User user = new User();
		user.setUsername("gurum");
		user.setPassword(encoder.encode("gurum222"));
		user.setName("방문자");
		user.setRole(Role.MEMBER);
		user.setEnabled(true);
		userRepository.save(user);
	}
}
