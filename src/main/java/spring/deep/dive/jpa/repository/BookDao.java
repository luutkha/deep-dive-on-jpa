package spring.deep.dive.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import spring.deep.dive.jpa.entity.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class BookDao {


    @PersistenceContext
    EntityManager em;

    // This code work fine, but so bad,  we can improve it, later :)
    public List<Book> findBooksByCreatedDateAndTitle(String title) throws ParseException {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> book = criteriaQuery.from(Book.class);
        Predicate titlePredicate = criteriaBuilder.like(book.get("title"), "%" + title + "%");
        String dateString = "2024-01-13 17:28:51.963000";
        String dateString2 = "2024-01-13 21:21:22.308000";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        Date from = format.parse(dateString);
        Date to = format.parse(dateString2);
        Predicate createdDateQuery = criteriaBuilder.between(book.get("createdDate"), from, to);
        criteriaQuery.where(titlePredicate, createdDateQuery).orderBy(criteriaBuilder.desc(book.get("createdDate")));
        TypedQuery<Book> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

}