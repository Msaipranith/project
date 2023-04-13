package redoc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import redoc.controller.StudentController;
import redoc.pojo.BookPojo;
import redoc.pojo.StudentPojo;
import redoc.service.StudentService;
import redoc.util.ObjectCreator;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class StudentControllerTest {

	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService service;

	@InjectMocks
	ObjectCreator objectCreator;
	

	@Test
	@Order(1)
	public void saveDetailsTests() {

		Mockito.when(service.saveDetails(objectCreator.getData().get(0))).thenReturn(objectCreator.getData().get(0));
		studentController.saveDetails(objectCreator.getData().get(0));

	}

	@Test
	@Order(2)
	public void getEmpDetailsTests() {

		List<StudentPojo> data = new ArrayList<>();
		List<BookPojo> al = new ArrayList<>();
		al.add(new BookPojo("robinHood", "biopic"));
		al.add(new BookPojo("sherlockHomes", "essay"));

		data.add(new StudentPojo("pranith", 23, "saipranithsunny@gmail.com", al));
		Mockito.when(service.getStudentDetails()).thenReturn(new ResponseEntity<>(data, HttpStatus.FOUND));
		studentController.getStudentDetails();

		assertEquals(new ResponseEntity<>(data, HttpStatus.FOUND), studentController.getStudentDetails());
	}

	@Test
	@Order(3)
	public void getStudentDetailsByIdTests() throws Exception {

		Mockito.when(service.getStudentDetailsById(Mockito.anyInt()))
				.thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		assertEquals(new ResponseEntity<>(HttpStatus.NOT_FOUND),
				studentController.getStudentDetailsById(Mockito.anyInt()));

	}

	@Test
	@Order(4)
	public void getBookDetailsByIdTests() {

		Mockito.when(service.getBookDetailsById(Mockito.anyInt())).thenReturn(objectCreator.getBookPojo());
		assertEquals(objectCreator.getBook().getBookId(),
				studentController.getBookDetailsById(1).getBody().getBookId());

	}

	@Test
	@Order(5)
	public void getBookDetailsByIdTests_IfBookWithIdNotExist() {

		Mockito.when(service.getBookDetailsById(Mockito.anyInt())).thenReturn(null);
		assertEquals(null, studentController.getBookDetailsById(1).getBody());

	}

}
