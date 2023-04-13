package redoc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import redoc.exception.TclException;
import redoc.pojo.BookPojo;
import redoc.pojo.StudentPojo;

public interface StudentService {

	StudentPojo saveDetails(StudentPojo student);

	ResponseEntity<List<StudentPojo>> getStudentDetails();

	ResponseEntity<StudentPojo> getStudentDetailsById(int id) throws TclException;

	BookPojo getBookDetailsById(int id);

	

}
