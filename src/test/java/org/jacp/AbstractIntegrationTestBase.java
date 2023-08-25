package org.jacp;

import org.jacp.initializer.Postgres;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author saffchen created on 24.08.2023
 */
@ActiveProfiles("test")
@Transactional
@ContextConfiguration(initializers = Postgres.Initializer.class)
@SpringBootTest
public abstract class AbstractIntegrationTestBase {
    @BeforeAll
    public static void init(){
        Postgres.container.start();
    }
}