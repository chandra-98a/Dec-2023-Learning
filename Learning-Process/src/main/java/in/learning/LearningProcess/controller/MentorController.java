package in.learning.LearningProcess.controller;

import java.util.ArrayList;
import java.util.List;

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
	@GetMapping("/mentorsList")
	public List<Mentor> getMentorList(){
		List<Mentor> mentor=new ArrayList<>();
		mentor.add(new Mentor(1,"Naveen","naveen@gmail.com","Azure Team"));
		mentor.add(new Mentor(2,"Sonu","sonu@gmail.com","AWS Architect"));
		mentor.add(new Mentor(3,"Prasanna","prasu@gmail.com","Agile Developer"));
		
		return mentor;
	}
}
