package spring.deep.dive.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.deep.dive.jpa.entity.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends BaseRepository<Person, Long>,
        CommonRepository<Person>{
    Optional<Person> findByName(String name);
}