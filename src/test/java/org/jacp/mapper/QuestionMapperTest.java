package org.jacp.mapper;

import org.jacp.dto.QuestionDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author saffchen created on 10.08.2023
 */
@ExtendWith(MockitoExtension.class)
class QuestionMapperTest {

    @Mock
    private QuestionEntity questionEntity;

    @InjectMocks
    private QuestionMapperImpl questionMapper;

    @Test
    void questionToQuestionDto() {
        Mockito.when(questionEntity.getId()).thenReturn(1L);
        Mockito.when(questionEntity.getProblem()).thenReturn("TestProblem");
        Mockito.when(questionEntity.getDifficult()).thenReturn(Difficult.EASY);
        Mockito.when(questionEntity.getDescription()).thenReturn("TestDescription");
        Mockito.when(questionEntity.getImports()).thenReturn("TestImports");
        Mockito.when(questionEntity.getBody()).thenReturn("TestBody");
        Mockito.when(questionEntity.getTest()).thenReturn("TestTest");
        QuestionDto questionDto = questionMapper.questionToQuestionDto(questionEntity);
        assertEquals(1L, questionDto.getId());
        assertEquals("TestProblem", questionDto.getProblem());
        assertEquals("EASY", questionDto.getDifficult());
        assertEquals("TestDescription", questionDto.getDescription());
        assertEquals("TestImports", questionDto.getImports());
        assertEquals("TestBody", questionDto.getBody());
        assertEquals("TestTest", questionDto.getTest());
    }
}