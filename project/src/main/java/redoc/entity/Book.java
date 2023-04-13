package redoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Entity
@Table(name = "book_table")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int bookId;

	private String bookName;
	private String bookType;
	public Book(String bookName, String bookType) {
		super();
		this.bookName = bookName;
		this.bookType = bookType;
	}



}
