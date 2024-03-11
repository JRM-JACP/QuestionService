package org.jacp.repository;

import org.jacp.entity.QuestionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author saffchen created on 31.07.2023
 */
@Transactional(readOnly = true)
@Repository
public interface QuestionRepository extends BaseRepository<QuestionEntity> {
    @Override
    Optional<QuestionEntity> findById(Long id);

    @Query("from QuestionEntity qe where qe.id in (:id)")
    List<QuestionEntity> getTasks(List<Long> id);
}