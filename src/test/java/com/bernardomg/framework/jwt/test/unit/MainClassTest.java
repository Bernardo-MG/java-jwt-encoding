package com.bernardomg.framework.jwt.test.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.bernardomg.framework.jwt.MainClass;

class MainClassTest {

    @Test
    void returnsProjectName() {
        assertEquals("Java JWT", MainClass.projectName());
    }
}
