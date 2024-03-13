package org.jacp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @author saffchen created on 17.01.2024
 */
@Repository
public class QuestionCriteria {

    @PersistenceContext
    private final EntityManager entityManager;

    public QuestionCriteria(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<QuestionEntity> findByFilter(int limitTask, Difficulty difficulty, List<Tags> tags) {
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

        List<QuestionEntity> resultList = entityManager.createQuery(criteriaQuery)
                .setMaxResults(limitTask)
                .getResultList();

        Collections.shuffle(resultList);
        return resultList;
    }
}
