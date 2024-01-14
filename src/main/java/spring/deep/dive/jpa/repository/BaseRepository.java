package spring.deep.dive.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import spring.deep.dive.jpa.entity.common.AdditionalInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends AdditionalInfo, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> findByCreatedDateBetween(Date createdDate, Date toDate);
}
