package org.jacp.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author saffchen created on 30.07.2023
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String problem;

    @Column(nullable = false)
    private String difference;

    @Column(nullable = false)
    private String description;

    @Column
    private String imports;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String test;
}