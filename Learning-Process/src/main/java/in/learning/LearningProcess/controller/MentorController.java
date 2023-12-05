package in.learning.LearningProcess.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.learning.LearningProcess.bean.Mentor;

@RestController
public class MentorController {

	@GetMapping("/mentor")
	public Mentor getMentor() {
		Mentor mentor=new Mentor(
				1,"PaviPoovamma","pavi@gmail.com","Java Developer"
				);
		return mentor;
	}
}
