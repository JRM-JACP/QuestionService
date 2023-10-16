package org.jacp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author saffchen created on 15.09.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResultDto {
    private String imports;
    private String testImports;
    private String test;
}
