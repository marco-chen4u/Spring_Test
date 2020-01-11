package com.marco.petclinic.model;

import com.marco.petclinic.utils.TestInterface;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements TestInterface {

    // field
    private final Long DEFAULT_ID = RandomUtils.nextLong();

    @Test
    void groupAssertions() {
        // given
        Person person = new Person(DEFAULT_ID, "marco", "chan");

        // then
        assertAll("Test property set",
                ()->assertEquals(person.getFirstName(), "marco"),
                ()->assertEquals(person.getLastName(), "chan"));
    }

    @Test
    void groupAssertionMsgs() {
        // given
        Person person = new Person(DEFAULT_ID, "marco", "chan");

        // then
        assertAll("Test property set",
                ()->assertEquals(person.getFirstName(), "marco", "First name failed"),
                ()->assertEquals(person.getLastName(), "chan", "Last name failed"));
    }

    @RepeatedTest(value = 8, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
    @DisplayName("PersonTest-Repeated Test Method")
    void repeatedTestMethod() {
        // todo implementation
    }

}
