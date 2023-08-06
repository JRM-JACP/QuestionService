package org.jacp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author saffchen created on 02.08.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionDto {
    private Long id;

    private String problem;

    private String difference;

    private String description;

    private String imports;

    private String body;

    private String test;
}
