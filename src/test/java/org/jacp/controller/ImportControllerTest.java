package org.jacp.controller;

import org.jacp.dto.ResultDto;
import org.jacp.entity.ImportEntity;
import org.jacp.entity.QuestionEntity;
import org.jacp.entity.TestImportEntity;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;
import org.jacp.mapper.ResultTestImportsMapper;
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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.mockito.Mockito.verify;

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
    private ResultTestImportsMapper resultMapper;

    @InjectMocks
    private ImportController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllImports() throws Exception {

        List<ImportEntity> importEntities = new ArrayList<>();
        List<TestImportEntity> testImportEntities = new ArrayList<>();
        ImportEntity importEntity1 = new ImportEntity(1L, "import1");
        ImportEntity importEntity2 = new ImportEntity(2L, "import2");
        TestImportEntity testImportEntity1 = new TestImportEntity(1L, "testImport1");
        TestImportEntity testImportEntity2 = new TestImportEntity(2L, "testImport2");
        importEntities.add(importEntity1);
        importEntities.add(importEntity2);
        testImportEntities.add(testImportEntity1);
        testImportEntities.add(testImportEntity2);

        QuestionEntity questionEntity = new QuestionEntity();
        TestImportEntity testImportEntity = new TestImportEntity();
        List<Tags> tags = new ArrayList<>();
        tags.add(Tags.MATH);
        tags.add(Tags.STRING);
        Long questionId = 1L;
        String problem = "TestProblem";
        Difficulty difficulty = Difficulty.EASY;
        String description = "TestDescription";
        String body = "TestBody";
        String test = "Test";
        String testImports = "TestImports";
        questionEntity.setId(questionId);
        questionEntity.setProblem(problem);
        questionEntity.setDifficulty(difficulty);
        questionEntity.setTags(tags);
        questionEntity.setDescription(description);
        questionEntity.setBody(body);
        questionEntity.setTest(test);
        testImportEntity.setId(questionId);
        testImportEntity.setImports(testImports);

        Mockito.when(importService.getAllImports()).thenReturn(importEntities);
        Mockito.when(questionService.get(questionId)).thenReturn(questionEntity);
        Mockito.when(importService.getAllTestImports()).thenReturn(testImportEntities);

        String resultImport = importEntities.stream()
                .map(ImportEntity::getImports)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        String testImport = testImportEntities.stream()
                .map(TestImportEntity::getImports)
                .map(Objects::toString)
                .collect(Collectors.joining(" "));

        ResultDto expectedResult = new ResultDto(resultImport, testImport, test);
        Mockito.when(resultMapper.toResult(resultImport, testImport, test)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/" + questionId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.imports").value(resultImport))
                .andExpect(MockMvcResultMatchers.jsonPath("$.testImports").value(testImport))
                .andExpect(MockMvcResultMatchers.jsonPath("$.test").value(questionEntity.getTest()));

        verify(questionService).get(questionId);
        verify(importService).getAllImports();
        verify(importService).getAllTestImports();
    }
}
