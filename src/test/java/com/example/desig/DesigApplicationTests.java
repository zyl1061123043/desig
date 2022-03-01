package com.example.desig;

import ch.qos.logback.core.util.SystemInfo;
import com.sun.deploy.util.SystemUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.plugin2.util.SystemUtil;

@SpringBootTest
class DesigApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
