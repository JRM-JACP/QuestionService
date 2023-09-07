package org.jacp.service;

import org.jacp.entity.ImportEntity;
import org.jacp.repository.ImportRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author saffchen created on 07.09.2023
 */
@ExtendWith(MockitoExtension.class)
public class ImportServiceTest {

    @Mock
    private ImportRepository importRepository;

    @InjectMocks
    private ImportService importService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    static ImportEntity importEntity = new ImportEntity();

    static Long id = 1L;

    static String imports = "import lombok.AllArgsConstructor;";

    @BeforeAll
    static void prepareData() {
        importEntity.setId(id);
        importEntity.setImports(imports);
    }

    @Test
    void getAllTest() {
        Mockito.when(importRepository.getAll()).thenReturn(importEntity);
        ImportEntity result = importService.getAll();
        assertEquals(importEntity.getImports(), result.getImports());
    }
}
