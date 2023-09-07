package org.jacp.mapper;

import org.jacp.dto.QuestionDto;
import org.jacp.entity.QuestionEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * @author saffchen created on 02.08.2023
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface QuestionMapper {
    QuestionDto questionToQuestionDto(QuestionEntity questionEntity);
}