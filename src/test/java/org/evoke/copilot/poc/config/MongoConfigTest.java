package org.evoke.copilot.poc.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MongoConfigTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void mongoTemplateBeanExists() {
        assertNotNull(mongoTemplate);
    }
}