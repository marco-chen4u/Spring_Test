package com.marco.petclinic.model;

import com.marco.petclinic.utils.TestInterface;
import com.marco.petclinic.utils.Utils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements TestInterface {
    // fields
    private final Long DEFAULT_ID = RandomUtils.nextLong();

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(DEFAULT_ID, "marco", "chan");
        owner.setCity("Chicago");
        owner.setTelephone("321-558-4389");

        assertAll("Owner Entity Properties Test",
                ()->{
                    assertAll("Person Properties",
                            ()->assertEquals("marco", owner.getFirstName(), "First name not correct"),
                            ()->assertEquals("chan", owner.getLastName(), "Last name not correct"));
                },
                ()->{
                    assertAll("Owner Properties",
                            ()->assertEquals("Chicago", owner.getCity(), "City is not correct"),
                            ()->assertEquals("321-558-4389", owner.getTelephone(), "Telephone number is not correct"));
                }
                );
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Marco"})
    void testValueSource(String sourceVal) {
        System.out.println(sourceVal);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource(
            {
                    "IL, 1, 1",
                    "FL, 2, 2",
                    "MD, 3, 3",
                    "TN, 4, 4",
                    "CA, 5, 5"
            }
    )
    void csvInputTest(String stateName, int value1, int value2) {
        System.out.println(stateName + " = " + value1 + " : " + value2);
    }

    @DisplayName("CSV source from Tile  Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/mock_data_1.csv", numLinesToSkip = 1)
    void csvSourceFileValueTest(int id,
                                String firstName,
                                String lastName,
                                String email,
                                String gender,
                                String ipAddress) {
        System.out.println("id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email + ", gender = " + gender + ", ipAddress = " + ipAddress);
    }

    // CustomArgsProvider method testing
    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void methodProviderTest(int id,
                            String firstName,
                            String lastName,
                            String email) {
        System.out.println("id = " + id + ", firstName = " + firstName + ", lastName = " + lastName + ", email = " + email);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of(Utils.getRandomIntID(), "Amandi", "Sybe", "asybe1@booking.com"),
                Arguments.of(Utils.getRandomIntID(), "Grazia", "Alker", "galker2@umich.edu"),
                Arguments.of(Utils.getRandomIntID(), "Aloise", "Varga", "avarga3@google.cn"),
                Arguments.of(Utils.getRandomIntID(), "Sarette", "Dobrowlski", "sdobrowlski4@yale.edu"),
                Arguments.of(Utils.getRandomIntID(), "Rab", "Pieche", "rpieche5@trellian.com")
        );
    }
}
