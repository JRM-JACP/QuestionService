package org.jacp.mapper;

import org.jacp.dto.ImportDto;
import org.jacp.entity.ImportEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author saffchen created on 07.09.2023
 */
@ExtendWith(MockitoExtension.class)
public class ImportMapperTest {

    @Mock
    private ImportEntity entity;

    @InjectMocks
    private ImportMapperImpl importMapper;

    @Test
    void importToImportDto() {
        Mockito.when(entity.getImports()).thenReturn("import lombok.AllArgsConstructor;");
        ImportDto importDto = importMapper.importToImportDto(entity);
        assertEquals("import lombok.AllArgsConstructor;", importDto.getImports());
    }
}
