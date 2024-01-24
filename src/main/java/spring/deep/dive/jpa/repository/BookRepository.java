package spring.deep.dive.jpa.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.deep.dive.jpa.entity.Book;

import java.util.Optional;

@Repository

// readOnly = true marked this repository only read data
//@Transactional(readOnly = true)
// DO NOT import  jakarta.transaction.Transactional instead of org.springframework.transaction.annotation.Transactional;
public interface BookRepository extends BaseRepository<Book, Long>,
        CommonRepository<Book>{
    Optional<Book> findByTitle(String title);

    // @Modifying imply this method below have readOnly = false
    @Modifying
    @Transactional
//    @Query("delete from Book b where b.title = ?")
    Optional<Book> deleteBookByTitle(String title);
}