package redoc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redoc.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
