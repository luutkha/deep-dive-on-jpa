package spring.deep.dive.jpa.repository.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import spring.deep.dive.jpa.entity.common.AdditionalInfo;
import spring.deep.dive.jpa.repository.CommonRepository;

public class CommonRepositoryImpl<T extends AdditionalInfo> implements CommonRepository<T> {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void findByCreatedDate(T entity) {
        entity.getCreatedDate();
//        Table table = Entity.class.getAnnotation(entity.getClass().getName());
        em.createNativeQuery("select * from ",entity.getClass().getName().toLowerCase());
//        em.createQuery("Select * from ", T.);
//        em.(entity);

//        em.find(T,)
    }
}
