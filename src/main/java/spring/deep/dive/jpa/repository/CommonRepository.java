package spring.deep.dive.jpa.repository;

public interface CommonRepository<T> {
    void findByCreatedDate(T entity);
}
