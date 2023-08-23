package org.jacp.repository;

import org.jacp.entity.QuestionEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author saffchen created on 22.08.2023
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class QuestionRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;

    @Test
    void testFindById() {
        Long id = 1L;
        Optional<QuestionEntity> optionalQuestion = questionRepository.findById(id);
        assertTrue(optionalQuestion.isPresent());
        QuestionEntity question = optionalQuestion.get();
        assertEquals(id, question.getId());
        assertEquals("Grasshopper", question.getProblem());
    }
}