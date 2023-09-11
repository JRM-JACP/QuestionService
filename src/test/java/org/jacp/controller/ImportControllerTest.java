package org.jacp.controller;

import org.jacp.dto.ImportDto;
import org.jacp.dto.QuestionTestFieldDto;
import org.jacp.entity.ImportEntity;
import org.jacp.entity.QuestionEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.jacp.mapper.ImportMapper;
import org.jacp.mapper.QuestionMapper;
import org.jacp.service.ImportService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author saffchen created on 07.09.2023
 */
@ExtendWith(MockitoExtension.class)
public class ImportControllerTest {

    static final String URL = "/api/v1/imports";

    @Mock
    private ImportService importService;

    @Mock
    private QuestionService questionService;

    @Mock
    private ImportMapper importMapper;

    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private ImportController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllImports() throws Exception {
        List<ImportEntity> importEntity = Arrays.asList(
                new ImportEntity(1L, "import 1"),
                new ImportEntity(2L, "import 2"),
                new ImportEntity(3L, "import 3")
        );

        List<ImportDto> importDto = Arrays.asList(
                new ImportDto(List.of("import 1")),
                new ImportDto(List.of("import 2")),
                new ImportDto(List.of("import 3"))
        );

        QuestionEntity questionEntity = new QuestionEntity();
        QuestionTestFieldDto questionDto = new QuestionTestFieldDto();
        List<Tags> tags = new ArrayList<>();
        tags.add(Tags.MATH);
        tags.add(Tags.STRING);
        Long questionId = 1L;
        String problem = "TestProblem";
        Difficulty difficulty = Difficulty.EASY;
        String description = "TestDescription";
        String body = "TestBody";
        String test = "Test";
        questionEntity.setId(questionId);
        questionEntity.setProblem(problem);
        questionEntity.setDifficulty(difficulty);
        questionEntity.setTags(tags);
        questionEntity.setDescription(description);
        questionEntity.setBody(body);
        questionEntity.setTest(test);
        questionDto.setTest(test);

        Mockito.when(importService.getAll()).thenReturn(importEntity);
        Mockito.when(importMapper.toImportDto(importEntity)).thenReturn(importDto);
        Mockito.when(questionService.get(questionId)).thenReturn(questionEntity);
        Mockito.when(questionMapper.toTestFieldQuestionDto(questionEntity)).thenReturn(questionDto);

        List<ImportDto> importDtoMapper = importMapper.toImportDto(importEntity);

        String resultImport = importDtoMapper.stream()
                .map(ImportDto::getImports)
                .map(Object::toString)
                .map(s -> s.replace("[", "").replace("]", "; "))
                .collect(Collectors.joining());

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/" + questionId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.imports").value(resultImport))
                .andExpect(MockMvcResultMatchers.jsonPath("$.test").value(questionDto.getTest()));
    }
}
