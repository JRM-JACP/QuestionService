package org.jacp.repository;

import org.jacp.AbstractIntegrationTestBase;
import org.jacp.entity.QuestionEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author saffchen created on 22.08.2023
 */
@SqlGroup({
        @Sql("/sql/dropData.sql"),
        @Sql("/sql/data.sql")
})
class QuestionRepositoryTest extends AbstractIntegrationTestBase {
    @Autowired
    private QuestionRepository questionRepository;

    private static final Long QUESTION_ID = 1L;

    @Test
    void testFindById() {
        Optional<QuestionEntity> optionalQuestion = questionRepository.findById(QUESTION_ID);
        assertTrue(optionalQuestion.isPresent());
        optionalQuestion.ifPresent(entity -> {
            assertEquals(QUESTION_ID, entity.getId());
            assertEquals("Grasshopper", entity.getProblem());
        });
    }
}