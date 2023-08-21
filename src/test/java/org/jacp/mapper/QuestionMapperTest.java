package org.jacp.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.jacp.dto.QuestionDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Mockito.when(questionEntity.getDifficulty()).thenReturn(Difficulty.EASY);
        Mockito.when(questionEntity.getTags()).thenReturn(List.of(Tags.MATH, Tags.STRING));
        Mockito.when(questionEntity.getDescription()).thenReturn("TestDescription");
        Mockito.when(questionEntity.getImports()).thenReturn("TestImports");
        Mockito.when(questionEntity.getBody()).thenReturn("TestBody");
        Mockito.when(questionEntity.getTest()).thenReturn("TestTest");
        QuestionDto questionDto = questionMapper.questionToQuestionDto(questionEntity);
        assertEquals(1L, questionDto.getId());
        assertEquals("TestProblem", questionDto.getProblem());
        assertEquals("EASY", questionDto.getDifficulty());
        assertTrue(CollectionUtils.isEqualCollection(List.of("STRING", "MATH"), questionDto.getTags()));
        assertEquals("TestDescription", questionDto.getDescription());
        assertEquals("TestImports", questionDto.getImports());
        assertEquals("TestBody", questionDto.getBody());
        assertEquals("TestTest", questionDto.getTest());
    }
}