package org.jacp.dto;

import lombok.*;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;

import java.util.List;

/**
 * @author saffchen created on 17.12.2023
 */
@Data
public class SearchDto {
    private int limitTasks;
    private Difficulty difficulty;
    private List<Tags> tagsList;
}
