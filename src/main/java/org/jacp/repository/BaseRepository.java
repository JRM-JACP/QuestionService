package org.jacp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author saffchen created on 31.07.2023
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
}
