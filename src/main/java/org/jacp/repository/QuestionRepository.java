package org.jacp.repository;

import org.jacp.entity.QuestionEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author saffchen created on 31.07.2023
 */
@Transactional(readOnly = true)
@Repository
public interface QuestionRepository extends BaseRepository<QuestionEntity> {

}