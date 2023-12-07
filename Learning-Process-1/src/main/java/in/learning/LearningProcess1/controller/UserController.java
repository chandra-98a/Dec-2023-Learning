package in.learning.LearningProcess1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.learning.LearningProcess1.entity.User;
import in.learning.LearningProcess1.service.UserService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	


	//create user
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser=userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	//get user by id http://localhost:8080/user/1
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user=userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
