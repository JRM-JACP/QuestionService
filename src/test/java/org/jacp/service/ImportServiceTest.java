package org.jacp.service;

import org.jacp.entity.ImportEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author saffchen created on 07.09.2023
 */
@ExtendWith(MockitoExtension.class)
public class ImportServiceTest {

    @InjectMocks
    private ImportService importService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    static Long id1 = 1L;
    static Long id2 = 2L;
    static Long id3 = 3L;
    static String imports1 = "import 1";
    static String imports2 = "import 2";
    static String imports3 = "import 3";

    @Test
    public void testGetAll() {
        List<ImportEntity> importEntity = Arrays.asList(
                new ImportEntity(id1, imports1),
                new ImportEntity(id2, imports2),
                new ImportEntity(id3, imports3)
        );

        List<ImportEntity> expectedEntity = Arrays.asList(
                new ImportEntity(id1, imports1),
                new ImportEntity(id2, imports2),
                new ImportEntity(id3, imports3)
        );

        Mockito.when(importService.getAll()).thenReturn(importEntity);
        List<ImportEntity> result = importService.getAll();
        String resultString = result.stream()
                .map(ImportEntity::getImports)
                .map(Objects::toString)
                .collect(Collectors.joining());

        String expectedString = expectedEntity.stream()
                .map(ImportEntity::getImports)
                .map(Objects::toString)
                .collect(Collectors.joining());

        Assertions.assertEquals(expectedString, resultString);
    }
}
