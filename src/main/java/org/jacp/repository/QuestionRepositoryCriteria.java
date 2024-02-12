package org.jacp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author saffchen created on 17.01.2024
 */
@Repository
public class QuestionRepositoryCriteria {

    @PersistenceContext
    private final EntityManager entityManager;

    public QuestionRepositoryCriteria(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<QuestionEntity> findByFilter(Pageable pageable, Difficulty difficulty, List<Tags> tags) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<QuestionEntity> criteriaQuery = criteriaBuilder.createQuery(QuestionEntity.class);
        Root<QuestionEntity> root = criteriaQuery.from(QuestionEntity.class);

        criteriaQuery.select(root);

        if (difficulty != null) {
            Predicate difficultyPredicate = criteriaBuilder.equal(root.get("difficulty"), difficulty);
            criteriaQuery.where(difficultyPredicate);
        }

        if (tags != null && !tags.isEmpty()) {
            Join<Object, Object> tagsJoin = root.join("tags");
            Predicate tagsPredicate = tagsJoin.in(tags);
            if (criteriaQuery.getRestriction() != null) {
                criteriaQuery.where(criteriaBuilder.and(criteriaQuery.getRestriction(), tagsPredicate));
            } else {
                criteriaQuery.where(tagsPredicate);
            }
        }

        criteriaQuery.orderBy(criteriaBuilder.asc(
                criteriaBuilder.function("random", Integer.class)
        ));

        return entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
    }
}