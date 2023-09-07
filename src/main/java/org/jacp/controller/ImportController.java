package org.jacp.controller;

import org.jacp.dto.ImportDto;
import org.jacp.entity.ImportEntity;
import org.jacp.mapper.ImportMapper;
import org.jacp.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author saffchen created on 06.09.2023
 */
@RestController
@RequestMapping(value = ImportController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ImportController {

    static final String URL = "/api/v1/imports";

    @Autowired
    ImportService service;

    @Autowired
    ImportMapper mapper;

    @GetMapping
    public ResponseEntity<ImportDto> getAll() {
        ImportEntity importEntity = service.getAll();
        ImportDto importDto = mapper.importToImportDto(importEntity);
        return ResponseEntity.ok(importDto);
    }
}