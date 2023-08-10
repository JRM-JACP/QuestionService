package org.jacp.mapper;

import org.jacp.dto.QuestionDto;
import org.jacp.entity.QuestionEntity;
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
        Mockito.doReturn(1L).when(questionEntity).getId();
        Mockito.doReturn("TestProblem").when(questionEntity).getProblem();
        Mockito.doReturn("TestDifficult").when(questionEntity).getDifficult();
        Mockito.doReturn("TestDescription").when(questionEntity).getDescription();
        Mockito.doReturn("TestImports").when(questionEntity).getImports();
        Mockito.doReturn("TestBody").when(questionEntity).getBody();
        Mockito.doReturn("TestTest").when(questionEntity).getTest();
        QuestionDto questionDto = questionMapper.questionToQuestionDto(questionEntity);
        assertEquals(1L, questionDto.getId());
        assertEquals("TestProblem", questionDto.getProblem());
        assertEquals("TestDifficult", questionDto.getDifficult());
        assertEquals("TestDescription", questionDto.getDescription());
        assertEquals("TestImports", questionDto.getImports());
        assertEquals("TestBody", questionDto.getBody());
        assertEquals("TestTest", questionDto.getTest());
    }
}