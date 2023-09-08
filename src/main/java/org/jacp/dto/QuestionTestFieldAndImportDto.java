package org.jacp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author saffchen created on 08.09.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionTestFieldAndImportDto {
    private QuestionTestFieldDto questionTestFieldDto;
    private List<ImportDto> importDto;
}
