package spring.deep.dive.jpa.repository;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import spring.deep.dive.jpa.dto.PersonNickNameOnly;
import spring.deep.dive.jpa.entity.Person;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface PersonRepository extends BaseRepository<Person, Long>,
        CommonRepository<Person>{
    Optional<Person> findByName(String name);

     Collection<PersonNickNameOnly> findAllWithProjector( PersonNickNameOnly type);

    <T> Collection<T> findAll( Class<T> type);


}