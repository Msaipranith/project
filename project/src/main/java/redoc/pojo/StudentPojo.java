package redoc.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPojo {

	private int studentId;
	private String studentName;
	private int studentAge;

	private String studentEmail;

	private List<BookPojo> book;

	public StudentPojo(String studentName, int studentAge, String studentEmail, List<BookPojo> book) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
		this.book = book;
	}

	

//	{
//		"studentName":"pranith",
//		"studentAge":23,
//		"studentEmail":"pranith@gmail.com",
//		"book":[
//		        
//		        {
//		        	"bookName":"robinhood",
//		        	"bookType":"biopic"
//		        },
//		        
//		        {
//		        	"bookName":"sherlockhomes",
//		        	"bookType":"essay"
//		        }
//		        
//		        ]
//				
//		
//	}

}
