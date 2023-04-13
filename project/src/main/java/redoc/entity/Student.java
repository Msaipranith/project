package redoc.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int studentId;

	private String studentName;
	private int studentAge;

	private String studentEmail;



	@JoinColumn(name = "fk_book_Id", referencedColumnName = "studentId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Book> book;



	public Student(String studentName, int studentAge, String studentEmail, List<Book> book) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
		this.book = book;
	}






}
