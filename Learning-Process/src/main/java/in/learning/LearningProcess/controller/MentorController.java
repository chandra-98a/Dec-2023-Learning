package in.learning.LearningProcess.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//REST API with PathVariable  {id}=URI Template Variable
	@GetMapping("/mentor/{id}/{name}")
	public Mentor mentorPathVariable(@PathVariable("id") int mentorId,
			@PathVariable String name) {
		return new Mentor(mentorId,name,"naveen@gmail.com","Azure Team");
	}
	
	//REST API with @RequestParam
	//http://localhost:8080/mentor/query?id=1
	@GetMapping("/mentor/query")
	public Mentor mentorRequestVariable(@RequestParam int id) {
		return new Mentor(id,"Ashoka","ashok@gmail.com","IT team");
		
	}
}
