package in.learning.LearningProcess1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.learning.LearningProcess1.entity.User;
import in.learning.LearningProcess1.repository.UserRepository;
import in.learning.LearningProcess1.service.UserService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

}
