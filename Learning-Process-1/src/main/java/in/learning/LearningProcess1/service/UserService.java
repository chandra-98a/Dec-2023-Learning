package in.learning.LearningProcess1.service;

import java.util.List;

import in.learning.LearningProcess1.entity.User;

public interface UserService {

	User createUser(User user);
	User getUserById(int id);
	List<User> getAllUsers();
	User updateUser(User user);
}
