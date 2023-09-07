package org.jacp.mapper;

import org.jacp.dto.ImportDto;
import org.jacp.entity.ImportEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * @author saffchen created on 06.09.2023
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ImportMapper {

    ImportDto importToImportDto(ImportEntity importEntity);
}
