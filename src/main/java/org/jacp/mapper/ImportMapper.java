package org.jacp.mapper;

import org.jacp.dto.ImportDto;
import org.jacp.entity.ImportEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.List;

/**
 * @author saffchen created on 06.09.2023
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ImportMapper {

    List<ImportDto> toImportDto(List<ImportEntity> importEntity);

    default List<String> stringToList(String value) {
        return Arrays.asList(value.split(";"));
    }
}
