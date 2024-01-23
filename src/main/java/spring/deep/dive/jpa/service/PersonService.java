package spring.deep.dive.jpa.service;

import spring.deep.dive.jpa.entity.Person;

import java.util.Date;
import java.util.List;


public interface PersonService {

   List<Person> findByCreatedDate(Date fromDate);

//     @Transactional
// Transaction is not working if you put it in interface or interface method
//   Why? https://stackoverflow.com/questions/3120143/where-should-i-put-transactional-annotation-at-an-interface-definition-or-at-a
   List<Person> saveAllPerson(List<Person> personList);

}
