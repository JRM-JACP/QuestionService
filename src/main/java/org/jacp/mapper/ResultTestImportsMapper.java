package org.jacp.mapper;

import org.jacp.dto.ResultDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * @author saffchen created on 15.09.2023
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ResultTestImportsMapper {
    ResultDto toResult(String imports, String testImports, String test);
}
