package org.jacp.mapper;

import org.jacp.dto.ImportDto;
import org.jacp.entity.ImportEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author saffchen created on 07.09.2023
 */
@ExtendWith(MockitoExtension.class)
public class ImportMapperTest {

    @InjectMocks
    private ImportMapperImpl importMapper;


    @Test
    void importToImportDto() {
        List<ImportEntity> importEntity = Arrays.asList(
                new ImportEntity(1L, "import 1"),
                new ImportEntity(2L, "import 2"),
                new ImportEntity(3L, "import 3")
        );

        List<ImportDto> expectedImportDto = Arrays.asList(
                new ImportDto(List.of("import 1")),
                new ImportDto(List.of("import 2")),
                new ImportDto(List.of("import 3"))
        );

        String expectedImports = expectedImportDto.stream()
                .map(ImportDto::getImports)
                .map(Objects::toString)
                .collect(Collectors.joining());

        List<ImportDto> actualImportDto = importMapper.toImportDto(importEntity);

        String actualImports = actualImportDto.stream()
                .map(ImportDto::getImports)
                .map(Objects::toString)
                .collect(Collectors.joining());

        assertEquals(expectedImports, actualImports);
    }
}
