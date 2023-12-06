package in.learning.LearningProcess.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<Mentor> getMentor() {
		Mentor mentor=new Mentor(
				1,"PaviPoovamma","pavi@gmail.com","Java Developer"
				);
		//return new ResponseEntity<>(mentor, HttpStatus.OK);
		//return ResponseEntity.ok(mentor);
		return ResponseEntity.ok().header("custom-header","Chandu").body(mentor);
	}
	
	@GetMapping("/mentorsList")
	public ResponseEntity<List<Mentor>> getMentorList(){
		List<Mentor> mentor=new ArrayList<>();
		mentor.add(new Mentor(1,"Naveen","naveen@gmail.com","Azure Team"));
		mentor.add(new Mentor(2,"Sonu","sonu@gmail.com","AWS Architect"));
		mentor.add(new Mentor(3,"Prasanna","prasu@gmail.com","Agile Developer"));
		
		return ResponseEntity.ok(mentor);
	}
	
	//REST API with PathVariable  {id}=URI Template Variable
	@GetMapping("/mentor/{id}/{name}")
	public ResponseEntity<Mentor> mentorPathVariable(@PathVariable("id") int mentorId,
			@PathVariable String name) {
		Mentor mentor= new Mentor(mentorId,name,"naveen@gmail.com","Azure Team");
		return ResponseEntity.ok(mentor);
	}
	
	//REST API with @RequestParam
	//http://localhost:8080/mentor/query?id=1&name=Vasantha
	@GetMapping("/mentor/query")
	public ResponseEntity<Mentor> mentorRequestVariable(@RequestParam int id,
			@RequestParam String name) {
		Mentor mentor= new Mentor(id,name,"ashok@gmail.com","IT team");
		return ResponseEntity.ok(mentor);
		
	}
	
	//REST API with POST request
	@PostMapping("/mentor")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor) {
		System.out.println(mentor.getId());
		System.out.println(mentor.getName());
		System.out.println(mentor.getEmail());
		System.out.println(mentor.getRole());
		return new ResponseEntity<>(mentor,HttpStatus.CREATED);
	}
	
	
	//REST API with PUT request
	@PutMapping("/mentor/{id}")
	public ResponseEntity<Mentor> updateMentor(@RequestBody Mentor mentor,@PathVariable int id) {
		System.out.println(mentor.getName());
		System.out.println(mentor.getEmail());
		System.out.println(mentor.getRole());
		return new ResponseEntity<>(mentor,HttpStatus.OK);
	}
	
	//REST API with PathVariable  {id}=URI Template Variable Delete request
	
	@DeleteMapping("/mentor/{id}")
	public ResponseEntity<String> deleteMapping(@PathVariable int id) {
		System.out.println(id);
		return ResponseEntity.ok("Mentor delete successfully");
	}
}
