package org.jacp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;

/**
 * @author saffchen created on 17.12.2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchDto {
    private int limitTasks;
    private Difficulty difficulty;
    private Tags tagsList;
}
