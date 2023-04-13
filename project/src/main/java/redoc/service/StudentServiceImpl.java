package redoc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import redoc.entity.Book;
import redoc.entity.Student;
import redoc.exception.TclException;
import redoc.pojo.BookPojo;
import redoc.pojo.StudentPojo;
import redoc.repo.BookRepo;
import redoc.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	BookRepo bookRepo;

	@Override
	public StudentPojo saveDetails(StudentPojo studentPojo) {
		List<Book> list = new ArrayList<>();
		for (BookPojo pojo : studentPojo.getBook()) {
			Book b = new Book(pojo.getBookName(), pojo.getBookType());
			list.add(b);
		}
		Student student = new Student(studentPojo.getStudentName(), studentPojo.getStudentAge(),
				studentPojo.getStudentEmail(), list);
		LOGGER.info(" entering save details method : {}", student);
		studentRepo.save(student);
		return studentPojo;
	}

	@Override
	public ResponseEntity<List<StudentPojo>> getStudentDetails() {
		List<Student> data = studentRepo.findAll();

		List<StudentPojo> list = new ArrayList<>();
		for (Student stu : data) {
			List<Book> book = stu.getBook();
			List<BookPojo> pojo = new ArrayList<>();
			for (Book b : book) {
				BookPojo bp = new BookPojo(b.getBookId(), b.getBookName(), b.getBookType());
				pojo.add(bp);
			}

			StudentPojo sp = new StudentPojo(stu.getStudentId(), stu.getStudentName(), stu.getStudentAge(),
					stu.getStudentEmail(), pojo);

			list.add(sp);
		
			
			
			//BeanUtils.copyProperties();
			//BeanUtils.copyProperties(list);
		}
		return new ResponseEntity<>(list, HttpStatus.FOUND);

	}

//	@Override
//	public ResponseEntity<List<StudentPojo>> getStudentDetails() {
//		List<Student> data = studentRepo.findAll();
//
//		List<StudentPojo> list = new ArrayList<>();
//		for (Student stu : data) {
//			List<Book> book = stu.getBook();
//			List<BookPojo> pojo = new ArrayList<>();
//			for (Book b : book) {
//				BookPojo bp = new BookPojo();
//				BeanUtils.copyProperties(b, bp);
//				pojo.add(bp);
//			}
//
//			StudentPojo sp = new StudentPojo();
//			BeanUtils.copyProperties(stu, sp);
//			sp.setBook(pojo);
//
//			list.add(sp);
//		}
//
//		return new ResponseEntity<>(list, HttpStatus.FOUND);
//	}

	@Override
	public ResponseEntity<StudentPojo> getStudentDetailsById(int id) throws TclException {

		Optional<Student> studentData = Optional
				.ofNullable(studentRepo.findById(id).orElseThrow(() -> new TclException("id doesn't exist", 404)));

		if (studentData.isPresent()) {

			List<Book> book = studentData.get().getBook();
			List<BookPojo> pojo = new ArrayList<>();
			for (Book b : book) {
				BookPojo bp = new BookPojo(b.getBookId(), b.getBookName(), b.getBookType());
				pojo.add(bp);
			}
			StudentPojo sp = new StudentPojo(studentData.get().getStudentId(), studentData.get().getStudentName(),
					studentData.get().getStudentAge(), studentData.get().getStudentEmail(), pojo);

			return new ResponseEntity<>(sp, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public BookPojo getBookDetailsById(int id) {
		// TODO Auto-generated method stub
		Optional<Book> bookData = bookRepo.findById(id);

		if (bookData.isPresent()) {
			return new BookPojo(bookData.get().getBookId(), bookData.get().getBookName(), bookData.get().getBookType());
		} else {
			return null;
		}

	}

}
