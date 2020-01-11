package com.marco;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingTest {

    private Greeting greeting;

    @BeforeEach
    void setUp() {
        greeting = new Greeting();
    }

    @Test
    void helloWord() {
        assertEquals("Hello World", greeting.helloWord());
    }

    @Test
    void hellowWord() {
        String name = "Marco";
        assertEquals("Hello Marco", greeting.hellowWord(name));
    }

    @AfterEach
    void tearDown() {
        greeting = null;
    }

    @AfterAll
    static void afterAll() {

    }
}
