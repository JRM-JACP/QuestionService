package org.jacp.controller;

import org.jacp.mapper.QuestionMapper;
import org.jacp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author saffchen created on 04.08.2023
 */
public class AbstractStoreController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionMapper mapper;
}
