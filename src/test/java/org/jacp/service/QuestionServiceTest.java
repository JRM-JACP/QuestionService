package org.jacp.service;

import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.jacp.error.NoEntityException;
import org.jacp.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

/**
 * @author saffchen created on 10.08.2023
 */
@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    static QuestionEntity questionEntity = new QuestionEntity();
    static Long questionId = 1L;
    static String problem = "TestProblem";
    static Difficulty difficulty = Difficulty.EASY;
    static List<Tags> tags = List.of(Tags.MATH, Tags.STRING);
    static String description = "TestDescription";
    static String body = "TestBody";
    static String test = "TestTest";


    @BeforeAll
    static void prepareData() {
        questionEntity.setId(questionId);
        questionEntity.setProblem(problem);
        questionEntity.setDifficulty(difficulty);
        questionEntity.setTags(tags);
        questionEntity.setDescription(description);
        questionEntity.setBody(body);
        questionEntity.setTest(test);
    }

    @Test
    void getQuestionByIdTestService() {
        Mockito.when(questionRepository.findById(questionId)).thenReturn(Optional.of(questionEntity));
        QuestionEntity result = questionService.get(questionId);
        Assertions.assertEquals(questionEntity, result);
    }

    @Test
    void getNullQuestionByIdTestService() {
        Mockito.when(questionRepository.findById(questionId)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoEntityException.class, () -> questionService.get(questionId));
    }
}