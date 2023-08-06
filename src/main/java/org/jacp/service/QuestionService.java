package org.jacp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.jacp.entity.QuestionEntity;
import org.jacp.repository.QuestionRepository;
import org.jacp.error.NoEntityException;

/**
 * @author saffchen created on 01.08.2023
 */
@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionEntity get(Long id) throws NoEntityException{
        return questionRepository.findById(id)
                .orElseThrow(() -> new NoEntityException("Question with id " + id + " is not found"));
    }
}