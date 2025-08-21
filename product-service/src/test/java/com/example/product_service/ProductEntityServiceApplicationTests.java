package com.example.product_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModule;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
class ProductEntityServiceApplicationTests {

    @Test
    void contextLoads()
    {

        var am = ApplicationModules.of(ProductServiceApplication.class);
        am.verify();
        System.out.println(am);
        new Documenter(am).writeDocumentation();
    }

}
