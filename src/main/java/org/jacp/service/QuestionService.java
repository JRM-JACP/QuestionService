package org.jacp.service;

import lombok.AllArgsConstructor;
import org.jacp.dto.SearchDto;
import org.jacp.entity.QuestionEntity;
import org.jacp.error.NoEntityException;
import org.jacp.repository.QuestionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author saffchen created on 01.08.2023
 */
@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionEntity get(Long id) throws NoEntityException {
        return questionRepository.findById(id)
                .orElseThrow(() -> new NoEntityException("Question with id " + id + " is not found"));
    }

    public List<QuestionEntity> getFilter(SearchDto searchDto) {
        Pageable pageable = PageRequest.of(0, searchDto.getLimitTasks());
        return questionRepository.findByFilter(pageable, searchDto.getDifficulty(), searchDto.getTagsList())
                .orElseThrow(() -> new NoEntityException("Question with difficulty " + searchDto.getDifficulty() +
                        " or tags " + searchDto.getTagsList() + " is not found"));
    }
}