package spring.deep.dive.jpa.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.deep.dive.jpa.entity.Person;
import spring.deep.dive.jpa.repository.PersonRepository;
import spring.deep.dive.jpa.service.PersonService;

import java.util.ArrayList;
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
    // version 1
    //    @Override
//    @Transactional(rollbackOn = {NullPointerException.class})
//    public List<Person> saveAllPerson(List<Person> personList) {
//        if(personList.isEmpty()) {
//            // 1.  if data appear on DB, the transaction doesn't work
//            repository.save(new Person("TEST TRANSACTION 3"));
//
//            // 2. after test, it called insert query , and  throw Exception, and rollback. but make the application crash
//            // 3. how to fix it? Check version 2
//
//            throw new NullPointerException();
//        }
//        return repository.saveAll(new ArrayList<>());
//    }

    // version2
//    @Override
//    @Transactional(rollbackOn = {NullPointerException.class})
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
                    // check version 3
//                throw new NullPointerException();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        return repository.saveAll(new ArrayList<>());
//    }


    // version 3
    @Override
    @Transactional(rollbackOn = {NullPointerException.class})
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


        return repository.saveAll(new ArrayList<>());
    }
}
