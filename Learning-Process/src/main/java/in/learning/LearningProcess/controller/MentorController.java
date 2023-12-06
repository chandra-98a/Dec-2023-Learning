package in.learning.LearningProcess.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	//http://localhost:8080/mentor/query?id=1&name=Vasantha
	@GetMapping("/mentor/query")
	public Mentor mentorRequestVariable(@RequestParam int id,
			@RequestParam String name) {
		return new Mentor(id,name,"ashok@gmail.com","IT team");
		
	}
	
	//REST API with POST request
	@PostMapping("/mentor")
	@ResponseStatus(HttpStatus.CREATED)
	public Mentor createMentor(@RequestBody Mentor mentor) {
		System.out.println(mentor.getId());
		System.out.println(mentor.getName());
		System.out.println(mentor.getEmail());
		System.out.println(mentor.getRole());
		return mentor;
	}
	
	
	//REST API with PUT request
	@PutMapping("/mentor/{id}")
	public Mentor updateMentor(@RequestBody Mentor mentor,@PathVariable int id) {
		System.out.println(mentor.getName());
		System.out.println(mentor.getEmail());
		System.out.println(mentor.getRole());
		return mentor;
	}
}
