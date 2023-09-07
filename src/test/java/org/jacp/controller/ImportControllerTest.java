package org.jacp.controller;

import org.jacp.dto.ImportDto;
import org.jacp.entity.ImportEntity;
import org.jacp.mapper.ImportMapper;
import org.jacp.service.ImportService;
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
 * @author saffchen created on 07.09.2023
 */
@ExtendWith(MockitoExtension.class)
public class ImportControllerTest {

    static final String URL = "/api/v1/imports";

    @Mock
    private ImportService service;

    @Mock
    private ImportMapper mapper;

    @InjectMocks
    private ImportController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllImports() throws Exception {
        ImportEntity importEntity = new ImportEntity();
        ImportDto importDto = new ImportDto();

        String imports = "import lombok.AllArgsConstructor;";

        importEntity.setImports(imports);
        importDto.setImports(imports);

        Mockito.when(service.getAll()).thenReturn(importEntity);
        Mockito.when(mapper.importToImportDto(importEntity)).thenReturn(importDto);

        mockMvc.perform(MockMvcRequestBuilders.get(URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.imports").value(imports));
    }
}
