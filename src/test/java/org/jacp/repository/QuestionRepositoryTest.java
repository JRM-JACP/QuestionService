package org.jacp.repository;

import org.jacp.entity.QuestionEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author saffchen created on 11.08.2023
 */
@ExtendWith(MockitoExtension.class)
class QuestionRepositoryTest {
    @Mock
    private QuestionRepository questionRepository;

    @Test
    public void testFindById() {
        QuestionEntity questionEntity = new QuestionEntity();
        Long questionId = 1L;
        String problem = "TestProblem";
        String difficult = "TestDifficult";
        String description = "TestDescription";
        String imports = "TestImports";
        String body = "TestBody";
        String test = "TestTest";
        questionEntity.setId(questionId);
        questionEntity.setProblem(problem);
        questionEntity.setDifficult(difficult);
        questionEntity.setDescription(description);
        questionEntity.setImports(imports);
        questionEntity.setBody(body);
        questionEntity.setTest(test);

        Mockito.when(questionRepository.findById(1L)).thenReturn(Optional.of(questionEntity));

        Optional<QuestionEntity> result = questionRepository.findById(1L);

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getId()).isEqualTo(1L);
        assertThat(result.get().getProblem()).isEqualTo("TestProblem");

        Mockito.verify(questionRepository).findById(1L);
    }

}