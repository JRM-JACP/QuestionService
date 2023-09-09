package org.jacp.repository;

import org.jacp.AbstractIntegrationTestBase;
import org.jacp.entity.ImportEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author saffchen created on 07.09.2023
 */
@SqlGroup({
        @Sql("/sql/repository/questionRepositoryDropData.sql"),
        @Sql("/sql/repository/questionRepositoryData.sql")
})
public class ImportRepositoryTest extends AbstractIntegrationTestBase {

    @Autowired
    ImportRepository importRepository;

    @Test
    void getAllTest() {
        List<ImportEntity> importEntityTest = importRepository.findAll();
        String imports = importEntityTest.stream()
                .map(ImportEntity::getImports)
                .map(Object::toString)
                .collect(Collectors.joining());
        assertEquals("import lombok.AllArgsConstructor;", imports);
    }
}
