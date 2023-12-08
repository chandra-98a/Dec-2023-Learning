package in.learning.Testing1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.learning.Testing1.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
