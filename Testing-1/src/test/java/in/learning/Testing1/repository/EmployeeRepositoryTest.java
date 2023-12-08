package in.learning.Testing1.repository;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import in.learning.Testing1.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Junit test for save employee
	@Test
	@DisplayName(" save employee")
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
		
		//given-precondition or setup
		
		Employee employee=Employee.builder()
				.name("chandrakala")
				.email("chandrakala@gmail.com")
				.build();
		
		//when-action or behaviour we'ar testing
		Employee savedEmployee=employeeRepository.save(employee);
		
		//then-verify the output
		assertThat(savedEmployee).isNotNull();
	assertThat(savedEmployee.getId()).isGreaterThan(0);
	}

}
