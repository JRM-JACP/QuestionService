package org.jacp.mapper;

import org.apache.commons.collections4.CollectionUtils;
import org.jacp.dto.QuestionDto;
import org.jacp.dto.QuestionTestFieldDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author saffchen created on 10.08.2023
 */
@ExtendWith(MockitoExtension.class)
class QuestionMapperTest {

    @Mock
    private static QuestionEntity questionEntity;

    @InjectMocks
    private QuestionMapperImpl questionMapper;

    @Test
    void toQuestionDto() {
        when(questionEntity.getId()).thenReturn(1L);
        when(questionEntity.getProblem()).thenReturn("TestProblem");
        when(questionEntity.getDifficulty()).thenReturn(Difficulty.EASY);
        when(questionEntity.getTags()).thenReturn(List.of(Tags.MATH, Tags.STRING));
        when(questionEntity.getDescription()).thenReturn("TestDescription");
        when(questionEntity.getBody()).thenReturn("TestBody");
        QuestionDto questionDto = questionMapper.toQuestionDto(questionEntity);
        assertEquals(1L, questionDto.getId());
        assertEquals("TestProblem", questionDto.getProblem());
        assertEquals("EASY", questionDto.getDifficulty());
        assertTrue(CollectionUtils.isEqualCollection(List.of("STRING", "MATH"), questionDto.getTags()));
        assertEquals("TestDescription", questionDto.getDescription());
        assertEquals("TestBody", questionDto.getBody());
    }

    @Test
    void toTestFieldQuestionDto() {
        when(questionEntity.getTest()).thenReturn("test import");
        QuestionTestFieldDto questionDto = questionMapper.toTestFieldQuestionDto(questionEntity);
        assertEquals("test import", questionDto.getTest());
    }
}