package com.rubypaper.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.User;
import com.rubypaper.persistence.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User getUser(User user) {
		Optional<User> findUser = userRepository.findById(user.getName());
		if(findUser.isPresent()) {
			return findUser.get();
		}
		// 아이디(username)로 검색한 결과 데이터가 없으면 null을 리턴한다.
		return null;
	}
	
	
}
