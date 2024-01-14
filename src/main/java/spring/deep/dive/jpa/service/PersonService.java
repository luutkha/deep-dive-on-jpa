package spring.deep.dive.jpa.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import spring.deep.dive.jpa.entity.Person;
import spring.deep.dive.jpa.repository.PersonRepository;

import java.util.Date;
import java.util.List;

public interface PersonService {

   List<Person> findByCreatedDate(Date fromDate);

   @Transactional
   List<Person> saveAllPerson(List<Person> personList);

}
