package in.learning.LearningProcess1.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import in.learning.LearningProcess1.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}

