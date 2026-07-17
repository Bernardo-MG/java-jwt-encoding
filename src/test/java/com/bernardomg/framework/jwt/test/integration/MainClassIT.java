package com.bernardomg.framework.jwt.test.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.bernardomg.framework.jwt.MainClass;

class MainClassIT {

    @Test
    void integrationSuiteIsConfigured() {
        assertNotNull(MainClass.projectName());
    }
}
