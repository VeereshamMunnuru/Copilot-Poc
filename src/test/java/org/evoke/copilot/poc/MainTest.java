package org.evoke.copilot.poc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainTest {

    @Test
    void applicationStarts() {
        Main.main(new String[] {});
    }
}