package org.jacp.controller;

import org.jacp.dto.QuestionDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.mapper.QuestionMapper;
import org.jacp.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author saffchen created on 10.08.2023
 */
@ExtendWith(MockitoExtension.class)
class QuestionControllerTest {

    static final String URL = "/api/v1/questions";

    @Mock
    private QuestionMapper questionMapper;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private QuestionController questionController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(questionController).build();
    }

    @Test
    void getQuestionByIdTest() throws Exception {
        QuestionEntity questionEntity = new QuestionEntity();
        QuestionDto questionDto = new QuestionDto();
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
        questionDto.setId(questionId);
        questionDto.setProblem(problem);
        questionDto.setDifficult(difficult);
        questionDto.setDescription(description);
        questionDto.setImports(imports);
        questionDto.setBody(body);
        questionDto.setTest(test);

        Mockito.when(questionService.get(questionId)).thenReturn(questionEntity);
        Mockito.when(questionMapper.questionToQuestionDto(questionEntity)).thenReturn(questionDto);

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/" + questionId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(questionId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.problem").value(problem))
                .andExpect(MockMvcResultMatchers.jsonPath("$.difficult").value(difficult))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(description))
                .andExpect(MockMvcResultMatchers.jsonPath("$.imports").value(imports))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").value(body))
                .andExpect(MockMvcResultMatchers.jsonPath("$.test").value(test));
    }
}