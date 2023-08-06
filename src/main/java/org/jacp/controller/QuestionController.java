package org.jacp.controller;

import org.jacp.dto.QuestionDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.jacp.entity.QuestionEntity;

/**
 * @author saffchen created on 01.08.2023
 */

@RestController
@RequestMapping(value = QuestionController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController extends AbstractStoreController {
    static final String URL = "/api/v1/questions";

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> get(@PathVariable Long questionId) {
        QuestionEntity questionEntity = questionService.get(questionId);
        QuestionDto questionDto = mapper.questionToQuestionDto(questionEntity);
        return ResponseEntity.ok(questionDto);
    }
}