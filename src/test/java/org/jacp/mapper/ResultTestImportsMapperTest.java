package org.jacp.mapper;

import org.jacp.dto.ResultDto;
import org.jacp.entity.ImportEntity;
import org.jacp.entity.QuestionEntity;
import org.jacp.entity.TestImportEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author saffchen created on 02.12.2023
 */
@ExtendWith(MockitoExtension.class)
public class ResultTestImportsMapperTest {

    @Mock
    private ImportEntity importEntity;

    @Mock
    private TestImportEntity testImportEntity;

    @Mock
    private QuestionEntity questionEntity;

    @InjectMocks
    private ResultTestImportsMapperImpl resultTestImportsMapper;

    @Test
    void toResultDto() {
        when(importEntity.getImports()).thenReturn("import");
        when(testImportEntity.getImports()).thenReturn("testImport");
        when(questionEntity.getTest()).thenReturn("test");

        ResultDto resultDto = resultTestImportsMapper
                .toResult(importEntity.getImports(), testImportEntity.getImports(), questionEntity.getTest());

        assertEquals("import", resultDto.getImports());
        assertEquals("testImport", resultDto.getTestImports());
        assertEquals("test", resultDto.getTest());
    }
}
