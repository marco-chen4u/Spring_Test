package com.marco.petclinic.controller;

import com.marco.petclinic.utils.exception.ValueNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @AfterEach
    void tearDown() {
        indexController = null;
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
    }

    @Test
    void oupsHandler() {
        assertEquals("notImplemented", indexController.oupsHandler());
        assertTrue("notImplemented".equals(indexController.oupsHandler()), ()->"they are not the same as some character case style");
    }

    @Test
    void testExceptionHandler() {
        assertThrows(ValueNotFoundException.class, ()-> indexController.getException());
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "marco-chen")
    @Test
    void testIfUserMarco() {

    }

}
