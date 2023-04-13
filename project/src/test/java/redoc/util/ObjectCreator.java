package redoc.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import redoc.entity.Book;
import redoc.entity.Student;
import redoc.pojo.BookPojo;
import redoc.pojo.StudentPojo;

@Component
public class ObjectCreator {

	public List<Student> repoData() {
		// TODO Auto-generated method stub
		Student student = new Student();
		Book book = new Book();

		book.setBookId(1);
		book.setBookName("pranith");
		book.setBookType("essay");

		List<Book> books = new ArrayList<>();
		books.add(book);
		student.setBook(books);

		List<Student> listStudent = new ArrayList<>();
		student.setStudentAge(23);
		student.setStudentEmail("saipranithsunny@gmail.com");
		student.setStudentId(1);
		student.setStudentName("pranith");
		student.setBook(books);
		listStudent.add(student);

		return listStudent;
	}

	public List<StudentPojo> getData() {
		// TODO Auto-generated method stub
		StudentPojo student = new StudentPojo();
		BookPojo book = new BookPojo();

		book.setBookId(1);
		book.setBookName("pranith");
		book.setBookType("essay");

		List<BookPojo> books = new ArrayList<>();
		books.add(book);
		student.setBook(books);

		List<StudentPojo> listStudent = new ArrayList<>();
		student.setStudentAge(23);
		student.setStudentEmail("saipranithsunny@gmail.com");
		student.setStudentId(1);
		student.setStudentName("pranith");
		student.setBook(books);
		listStudent.add(student);

		return listStudent;
	}

	public Book getBook() {
		Book book = new Book();

		book.setBookId(1);
		book.setBookName("pranith");
		book.setBookType("essay");
		return book;

	}

	public BookPojo getBookPojo() {
		BookPojo book = new BookPojo();

		book.setBookId(1);
		book.setBookName("pranith");
		book.setBookType("essay");
		return book;

	}

	public StudentPojo getStudentPojo() {
		List<BookPojo> al = new ArrayList<>();

		BookPojo book1 = new BookPojo("robinHood", "biopic");
		BookPojo book2 = new BookPojo("sherlockHomes", "biopic");
		al.add(book1);
		al.add(book2);

		StudentPojo student = new StudentPojo("pranith", 23, "saipranithsunny@gmail.com", al);
		return student;
	}

}
