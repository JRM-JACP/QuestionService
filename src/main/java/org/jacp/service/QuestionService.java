package org.jacp.service;

import lombok.AllArgsConstructor;
import org.jacp.dto.SearchDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.error.NoEntityException;
import org.jacp.repository.QuestionRepository;
import org.jacp.repository.QuestionRepositoryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saffchen created on 01.08.2023
 */
@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    private QuestionRepositoryCriteria questionRepositoryCriteria;

    public QuestionEntity get(Long id) throws NoEntityException {
        return questionRepository.findById(id)
                .orElseThrow(() -> new NoEntityException("Question with id " + id + " is not found"));
    }

    public List<QuestionEntity> getFilter(SearchDto searchDto) {
        return questionRepositoryCriteria
                .findByFilter(searchDto.getLimitTasks(), searchDto.getDifficulty(), searchDto.getTagsList());
    }
}