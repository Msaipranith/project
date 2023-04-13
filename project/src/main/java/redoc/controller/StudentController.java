package redoc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import redoc.exception.TclException;
import redoc.pojo.BookPojo;
import redoc.pojo.StudentPojo;
import redoc.service.StudentService;

@RestController
//@RequestMapping("/student")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService service;

	@PostMapping("/saveDetails")
	public ResponseEntity<String> saveDetails(@RequestBody StudentPojo student) {
		service.saveDetails(student);
		LOGGER.info("save details to the database : {} ", student);
		return new ResponseEntity<>("saved Successfully", HttpStatus.CREATED);

	}

	@GetMapping("/getListOfStudents")
	public ResponseEntity<List<StudentPojo>> getStudentDetails() {
		LOGGER.info("fetching employee details...");
		return service.getStudentDetails();
	}

	@GetMapping("/getStudentDetailsById/{id}")
	public ResponseEntity<StudentPojo> getStudentDetailsById(@PathVariable int id) throws TclException {
		LOGGER.info("fetching employee details by id : {} ", id);
		return service.getStudentDetailsById(id);
	}

	@GetMapping("/getBookDetailsById/{id}")
	public ResponseEntity<BookPojo> getBookDetailsById(@PathVariable int id) {
		LOGGER.info("fetching book details by id : {} ", id);
		BookPojo pojo = service.getBookDetailsById(id);
		if (pojo != null) {
			return new ResponseEntity<>(pojo, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
