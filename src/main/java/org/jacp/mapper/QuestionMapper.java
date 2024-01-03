package org.jacp.mapper;

import org.jacp.dto.QuestionDto;
import org.jacp.entity.QuestionEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author saffchen created on 02.08.2023
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface QuestionMapper {
    QuestionDto toQuestionDto(QuestionEntity questionEntity);

    List<QuestionDto> toListQuestionDto(List<QuestionEntity> questionEntities);
}