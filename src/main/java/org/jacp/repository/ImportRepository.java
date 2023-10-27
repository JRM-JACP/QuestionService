package org.jacp.repository;

import org.jacp.entity.ImportEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author saffchen created on 06.09.2023
 */
@Transactional(readOnly = true)
@Repository
public interface ImportRepository extends BaseRepository<ImportEntity> {

}
