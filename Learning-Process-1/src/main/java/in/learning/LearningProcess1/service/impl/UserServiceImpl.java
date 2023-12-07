package in.learning.LearningProcess1.service.impl;

import java.util.List;
import java.util.Optional;

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

	//it retrieves user by id

	@Override
	public User getUserById(int id) {
		Optional<User> optionalUser=userRepository.findById(id);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User updateUser(User user) {
	User existingUser=userRepository.findById(user.getId()).get();
	existingUser.setName(user.getName());
	existingUser.setEmail(user.getEmail());
    User updatedUser=userRepository.save(existingUser);
		return updatedUser;
	}

}
