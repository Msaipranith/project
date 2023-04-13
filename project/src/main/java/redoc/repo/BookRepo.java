package redoc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redoc.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {



//	@Query(value="SELECT book_id\r\n"
//			+ "	FROM public.book_table a where a.fk_book_id=:id", nativeQuery = true)
//	List<Integer> findByStudentId(long id);



}
