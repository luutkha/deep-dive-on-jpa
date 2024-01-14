package spring.deep.dive.jpa.repository;

import org.springframework.stereotype.Repository;
import spring.deep.dive.jpa.entity.Book;
import spring.deep.dive.jpa.entity.Person;

import java.util.Optional;

@Repository
public interface BookRepository extends BaseRepository<Book, Long>,
        CommonRepository<Book>{
    Optional<Book> findByTitle(String title);
}