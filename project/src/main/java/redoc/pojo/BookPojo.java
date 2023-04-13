package redoc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {

	
	private int bookId;
	private String bookName;
	private String bookType;
	
	
	public BookPojo(String bookName, String bookType) {
		super();
		this.bookName = bookName;
		this.bookType = bookType;
	}

	
	
}
