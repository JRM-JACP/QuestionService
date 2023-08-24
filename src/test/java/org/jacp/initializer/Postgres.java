package org.jacp.initializer;

import lombok.experimental.UtilityClass;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * @author saffchen created on 24.08.2023
 */
@UtilityClass
public class Postgres {
    public static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14.4-alpine")
            .withDatabaseName("foo");
    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + container.getJdbcUrl(),
                    "spring.datasource.username=" + container.getUsername(),
                    "spring.datasource.password=" + container.getPassword()
                    ).applyTo(applicationContext);
        }
    }
}
