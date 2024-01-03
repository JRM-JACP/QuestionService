package org.jacp.repository;

import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.springframework.data.domain.Pageable;
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

    @Query("select qe from QuestionEntity qe where qe.difficulty=:difficulty or :difficulty is null " +
            "and :tags member of qe.tags or :tags is null order by random()")
    Optional<List<QuestionEntity>> findByFilter(Pageable pageable, Difficulty difficulty, Tags tags);
}