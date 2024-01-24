package spring.deep.dive.jpa.service;

import org.springframework.transaction.annotation.Transactional;
import spring.deep.dive.jpa.entity.Person;

import java.util.Date;
import java.util.List;


public interface PersonService {

   List<Person> findByCreatedDate(Date fromDate);

   @Transactional
   List<Person> saveAllPerson(List<Person> personList);

   List<Person> findAllByExample(Person person);

   List<Person> findAllByExampleAdvanced(Person person);

}
