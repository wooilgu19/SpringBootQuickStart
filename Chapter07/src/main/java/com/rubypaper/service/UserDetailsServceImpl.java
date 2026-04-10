package com.rubypaper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.User;
import com.rubypaper.persistence.UserRepository;

@Service
public class UserDetailsServceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 회원을 검색해서 UserDetails 객체를 설정한 후, 리턴한다.
		User user = userRepository.findById(username).get();
		
		if(user == null) {
			throw new UsernameNotFoundException(username + "없어요...");
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				"{noop}" + user.getPassword(), 
				AuthorityUtils.createAuthorityList("ROLE_" + user.getRole()));
	}

}



