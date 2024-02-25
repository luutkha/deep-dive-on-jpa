package spring.deep.dive.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.deep.dive.jpa.dto.PersonNickNameOnly;
import spring.deep.dive.jpa.entity.Person;
import spring.deep.dive.jpa.repository.PersonRepository;
import spring.deep.dive.jpa.service.PersonService;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> findByCreatedDate(Date fromDate) {
        return null;
    }

//     version 1
//        @Override
//    @Transactional(rollbackFor = {NullPointerException.class})
//    public List<Person> saveAllPerson(List<Person> personList) {
//        if(personList.isEmpty()) {
//            repository.save(new Person("TEST TRANSACTION 3"));
                // work fine, but our app crash for unhandled Exception
                // check version 2
//            throw new NullPointerException();
//        }
//        return repository.saveAll(new ArrayList<>());
//    }

//     version2
//    @Override
//    @Transactional(rollbackFor = {NullPointerException.class})
//    public List<Person> saveAllPerson(List<Person> personList) {
//        try {
//            if (personList.isEmpty()) {
//                // 1.  if data appear on DB, the transaction doesn't work
//                repository.save(new Person("TEST TRANSACTION 3"));
//
//                // after test, it called insert query , and  throw Exception, and rollback. but make the application crash
//                // how to fix it?
//                // this code will not work
//                // why? Transaction only rollback if Exception not caught inside method marked as @Transactional
//                // that mean  if you handle exception here, transaction not gonna rollback
//                // check version 3
//                throw new NullPointerException();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        return repository.saveAll(new ArrayList<>());
//    }


//    // version 3
    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    public List<Person> saveAllPerson(List<Person> personList) {

            if (personList.isEmpty()) {
                // 1.  if data appear on DB, the transaction doesn't work
                repository.save(new Person("TEST TRANSACTION 3"));

//                Transaction only rollback if Exception not caught inside method
//                that mean if you handle exception, transaction not gonna rollback
//
//                to solve it, we remove try/catch and surround try/catch where call this method.
                throw new NullPointerException();
            }


        return repository.saveAll(personList);
    }

    @Override
    public List<Person> findAllByExample(Person person) {
        return  repository.findAll(Example.of(person));
    }

    // Query by example, every except string type, only can compare with equalTo
    @Override
    public List<Person> findAllByExampleAdvanced(Person person) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("version")
               .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);
        Example<Person> example = Example.of(person, matcher);

        return repository.findAll(example);
    }

    @Override
    public Collection<PersonNickNameOnly> findAllWithProjector() {
        return repository.findAll(PersonNickNameOnly.class);
    }
}
