package in.learning.LearningProcess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//GetMapping http://localhost:8080/hello
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hi, welcome to learning process";
	}
	

}
