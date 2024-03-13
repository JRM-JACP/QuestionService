package org.jacp.service;

import lombok.AllArgsConstructor;
import org.jacp.dto.SearchDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.error.NoEntityException;
import org.jacp.repository.QuestionCriteria;
import org.jacp.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saffchen created on 01.08.2023
 */
@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    private QuestionCriteria questionCriteria;

    public QuestionEntity get(Long id) throws NoEntityException {
        return questionRepository.findById(id)
                .orElseThrow(() -> new NoEntityException("Question with id " + id + " is not found"));
    }

    public List<QuestionEntity> getFilter(SearchDto searchDto) {
        return questionCriteria
                .findByFilter(searchDto.getLimitTasks(), searchDto.getDifficulty(), searchDto.getTagsList());
    }

    public List<QuestionEntity> getQuestionsByIds(List<Long> ids) {
        return questionRepository.findByIdIn(ids);
    }
}