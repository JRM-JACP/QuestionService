package org.jacp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

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
    private String difficulty;
    private List<String> tags;
    private String description;
    private String body;
    private String test;
}