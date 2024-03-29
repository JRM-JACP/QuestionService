package org.jacp.controller;

import org.jacp.dto.ResultDto;
import org.jacp.entity.ImportEntity;
import org.jacp.entity.QuestionEntity;
import org.jacp.entity.TestImportEntity;
import org.jacp.mapper.ResultTestImportsMapper;
import org.jacp.service.ImportService;
import org.jacp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author saffchen created on 06.09.2023
 */
@RestController
@RequestMapping(value = ImportController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ImportController {

    static final String URL = "/api/v1/imports";
    @Autowired
    private ImportService importService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ResultTestImportsMapper resultMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ResultDto> getAllImportsAndTest(@PathVariable Long id) {
        QuestionEntity questionEntity = questionService.get(id);
        List<ImportEntity> importEntities = importService.getAllImports();
        List<TestImportEntity> importTestEntities = importService.getAllTestImports();

        String imports = importEntities.stream()
                .map(ImportEntity::getImports)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        String testImports = importTestEntities.stream()
                .map(TestImportEntity::getImports)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        ResultDto result = resultMapper.toResult(imports, testImports, questionEntity.getTest());

        return ResponseEntity.ok(result);
    }
}