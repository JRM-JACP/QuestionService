package org.jacp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.jacp.enums.Difficulty;
import org.jacp.enums.Tags;

import java.util.List;

/**
 * @author saffchen created on 30.07.2023
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String problem;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "question_tags", joinColumns = @JoinColumn(name = "question_id"))
    private List<Tags> tags;

    @Column(nullable = false)
    private String description;

    @Column
    private String imports;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private String test;
}