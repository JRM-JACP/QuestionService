package org.jacp.repository;

import org.jacp.AbstractIntegrationTestBase;
import org.jacp.entity.ImportEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

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
        ImportEntity importEntityTest = importRepository.getAll();
        assertEquals("import lombok.AllArgsConstructor;", importEntityTest.getImports());
    }
}
