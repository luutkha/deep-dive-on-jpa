package spring.deep.dive.jpa.runner;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.deep.dive.jpa.entity.Book;
import spring.deep.dive.jpa.entity.Person;
import spring.deep.dive.jpa.repository.BookDao;
import spring.deep.dive.jpa.repository.BookRepository;
import spring.deep.dive.jpa.repository.PersonRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Log4j2
public class MyCommandRunner implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookDao bookDao;

    @Override
    public void run(String... args) throws Exception {
        // Code to be executed at application startup
        System.out.println("Hello, this code runs at application startup!");
        if (personRepository.count() <= 0) {
            for (int i = 0; i < 1000000000; i++) {
                personRepository.save(new Person("random-name" + i));
            }
        }

        // why we need to parse from this?
        String dateString = "2024-01-13 17:28:51.963000";
        String dateString2 = "2024-01-13 17:28:51.965000";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

        Date from = format.parse(dateString);
        Date to = format.parse(dateString2);

//        List<Person> byCreatedDate = personRepository.findByCreatedDateBetween(from,to);
//        log.info(byCreatedDate.size());


        if (bookRepository.count() <= 0) {
            for (int i = 0; i < 100000; i++) {
                bookRepository.save(new Book("random-book-title" + i));
            }
        }

        List<Book> booksByAuthorNameAndTitle = bookDao.findBooksByCreatedDateAndTitle("random-book-title1");
        log.info(booksByAuthorNameAndTitle);
    }
}
