package ch.heigvd.ptl.sc.service;

import ch.heigvd.ptl.sc.converter.UserConverter;
import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.persistence.UserRepository;
import ch.heigvd.ptl.sc.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	public User register(UserTO userTO) {
		User user = userConverter.convertTargetToSource(userTO);
		
		user.setRole(User.Role.MEMBER);
		
		return userRepository.save(user);
	}
}
