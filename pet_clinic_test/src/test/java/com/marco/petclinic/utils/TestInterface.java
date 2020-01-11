package com.marco.petclinic.utils;

import org.junit.jupiter.api.*;

@Tag("model")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestInterface {

    @BeforeAll
    default void getTestInfo(TestInfo testInfo/*, RepetitionInfo repetitionInfo*/) {
        System.out.println("Running Test - " +
                            testInfo.getDisplayName() /*+ "-" +
                            repetitionInfo.getCurrentRepetition() + "/" +
                            repetitionInfo.getTotalRepetitions()*/);
    }

}
