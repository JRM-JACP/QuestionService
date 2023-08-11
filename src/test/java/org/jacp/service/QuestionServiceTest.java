package org.jacp.service;

import org.jacp.entity.QuestionEntity;
import org.jacp.error.NoEntityException;
import org.jacp.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

/**
 * @author saffchen created on 10.08.2023
 */
class QuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void get() {
        QuestionEntity questionEntity = new QuestionEntity();
        Long questionId = 1L;
        String problem = "TestProblem";
        String difficult = "TestDifficult";
        String description = "TestDescription";
        String imports = "TestImports";
        String body = "TestBody";
        String test = "TestTest";
        questionEntity.setId(questionId);
        questionEntity.setProblem(problem);
        questionEntity.setDifficult(difficult);
        questionEntity.setDescription(description);
        questionEntity.setImports(imports);
        questionEntity.setBody(body);
        questionEntity.setTest(test);

        Mockito.when(questionRepository.findById(questionId)).thenReturn(Optional.of(questionEntity));
        QuestionEntity result = questionService.get(questionId);
        Assertions.assertEquals(questionEntity, result);
    }

    @Test
    void getNull(){
        QuestionEntity questionEntity = new QuestionEntity();
        Long questionId = 1L;
        String problem = "TestProblem";
        String difficult = "TestDifficult";
        String description = "TestDescription";
        String imports = "TestImports";
        String body = "TestBody";
        String test = "TestTest";
        questionEntity.setId(questionId);
        questionEntity.setProblem(problem);
        questionEntity.setDifficult(difficult);
        questionEntity.setDescription(description);
        questionEntity.setImports(imports);
        questionEntity.setBody(body);
        questionEntity.setTest(test);

        Mockito.when(questionRepository.findById(questionId)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoEntityException.class, () -> questionService.get(questionId));
    }
}