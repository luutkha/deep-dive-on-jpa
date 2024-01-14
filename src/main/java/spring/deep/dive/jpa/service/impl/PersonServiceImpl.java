package spring.deep.dive.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.deep.dive.jpa.entity.Person;
import spring.deep.dive.jpa.repository.PersonRepository;
import spring.deep.dive.jpa.service.PersonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> findByCreatedDate(Date fromDate) {
        return null;
    }

    @Override
    public List<Person> saveAllPerson(List<Person> personList) {
        if(personList.isEmpty()) {
            throw new NullPointerException();
        }
        return repository.saveAll(new ArrayList<>());
    }
}
