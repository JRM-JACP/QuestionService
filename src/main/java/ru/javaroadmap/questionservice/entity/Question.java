package ru.javaroadmap.questionservice.entity;

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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String problem;

    @Column(nullable = false)
    private String description;
}