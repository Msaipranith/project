package redoc.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import redoc.entity.Student;
import redoc.exception.TclException;
import redoc.pojo.BookPojo;
import redoc.pojo.StudentPojo;
import redoc.repo.BookRepo;
import redoc.repo.StudentRepo;
import redoc.service.StudentServiceImpl;
import redoc.util.ObjectCreator;

@ExtendWith(SpringExtension.class)
public class StudentServiceImplTest {

	@InjectMocks
	StudentServiceImpl studentService;

	@InjectMocks
	ObjectCreator objectCreator;

	@Mock
	StudentRepo repo;

	@Mock
	BookRepo bookRepo;

	@Test
	@Order(1)
	public void getStudentDetails() {

		Mockito.when(repo.findAll()).thenReturn(objectCreator.repoData());
		ResponseEntity<List<StudentPojo>> stu = studentService.getStudentDetails();
		assertEquals(objectCreator.getData(), stu.getBody());

	}

	@Test
	@Order(2)
	public void saveDetailsTest() {

		Mockito.when(repo.save(Mockito.any(Student.class))).thenReturn(objectCreator.repoData().get(0));
		StudentPojo pojo = studentService.saveDetails(objectCreator.getData().get(0));
		assertEquals(objectCreator.getData().get(0), pojo);
	}

	@Test
	@Order(3)
	public void getStudentDetailsById() throws TclException {

		Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(objectCreator.repoData().get(0)));
		ResponseEntity<StudentPojo> pojo = studentService.getStudentDetailsById(1);
		assertEquals(objectCreator.getData().get(0).getStudentId(), pojo.getBody().getStudentId());
	}

	@Test
	@Order(4)
	public void getBookDetailById() {

		Mockito.when(bookRepo.findById(Mockito.anyInt())).thenReturn(Optional.of(objectCreator.getBook()));

		BookPojo pojo = studentService.getBookDetailsById(1);
		assertEquals(objectCreator.getBook().getBookId(), pojo.getBookId());

	}

	@Test
	@Order(5)
	public void getBookDetailById_IfBookIdNotPresent() {

		Mockito.when(bookRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());

		BookPojo pojo = studentService.getBookDetailsById(1);
		assertNull(pojo);

	}

}
