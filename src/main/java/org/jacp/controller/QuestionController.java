package org.jacp.controller;

import org.jacp.dto.QuestionDto;
import org.jacp.dto.SearchDto;
import org.jacp.entity.QuestionEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author saffchen created on 01.08.2023
 */
@RestController
@RequestMapping(value = QuestionController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController extends AbstractQuestionController {

    static final String URL = "/api/v1/questions";

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDto> get(@PathVariable Long questionId) {
        QuestionEntity questionEntity = questionService.get(questionId);
        QuestionDto questionDto = mapper.toQuestionDto(questionEntity);
        return ResponseEntity.ok(questionDto);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<QuestionDto>> getQuestionFilter(@RequestBody SearchDto searchDto) {
        List<QuestionEntity> questionEntity = questionService.getFilter(searchDto);
        List<QuestionDto> questionDto = mapper.toListQuestionDto(questionEntity);
        return ResponseEntity.ok(questionDto);
    }

    @PostMapping("/getTasksList")
    public ResponseEntity<List<QuestionDto>> getTasksCurrentCompetition(@RequestBody List<Long> questionIds){
        List<QuestionEntity> questionEntity = questionService.getTasks(questionIds);
        List<QuestionDto> questionDto = mapper.toListQuestionDto(questionEntity);
        return ResponseEntity.ok(questionDto);
    }
}