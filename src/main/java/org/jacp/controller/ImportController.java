package org.jacp.controller;

import org.jacp.dto.ImportDto;
import org.jacp.dto.QuestionTestFieldDto;
import org.jacp.entity.ImportEntity;
import org.jacp.entity.QuestionEntity;
import org.jacp.mapper.ImportMapper;
import org.jacp.mapper.QuestionMapper;
import org.jacp.service.ImportService;
import org.jacp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author saffchen created on 06.09.2023
 */
@RestController
@RequestMapping(value = ImportController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ImportController {

    static final String URL = "/api/v1/imports";

    @Autowired
    ImportService importService;

    @Autowired
    QuestionService questionService;

    @Autowired
    ImportMapper importMapper;

    @Autowired
    QuestionMapper questionMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getAllImportsAndTest(@PathVariable Long id) {
        QuestionEntity questionEntity = questionService.get(id);
        QuestionTestFieldDto questionTestFieldDto = questionMapper.toTestQuestionDto(questionEntity);
        List<ImportEntity> importEntity = importService.getAll();
        List<ImportDto> importDto = importMapper.toImportDto(importEntity);

        Map<String, String> result = new HashMap<>();
        String imports = importDto.stream()
                .map(ImportDto::getImports)
                .map(Object::toString)
                .map(s -> s.replace("[", "").replace("]", "; "))
                .collect(Collectors.joining());
        result.put("imports", imports);
        result.put("test", questionTestFieldDto.getTest());

        return ResponseEntity.ok(result);
    }
}