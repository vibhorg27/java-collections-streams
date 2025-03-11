package com.bridgelabz.junit;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class UserRegistrationRegexTest {

    @Test
    void testValidFirstName_HappyCase() {
        assertTrue(UserRegistration.validFirstName("Chanoey"));
    }


    @Test
    void testInvalidFirstName_SadCase() {
        assertFalse(UserRegistration.validFirstName("chanoey")); // Lowercase first letter
        assertFalse(UserRegistration.validFirstName("C"));     // Too short
        assertFalse(UserRegistration.validFirstName("Ch"));    // Less than 3 letters
    }


    @Test
    void testValidLastName_HappyCase() {
        assertTrue(UserRegistration.validLastName("Bing"));
    }


    @Test
    void testInvalidLastName_SadCase() {
        assertFalse(UserRegistration.validLastName("bing")); // Lowercase first letter
        assertFalse(UserRegistration.validLastName("B"));       // Too short
    }


    @Test
    void testValidMobileNumber_HappyCase() {
        assertTrue(UserRegistration.validNumber("91 9897656567"));
    }


    @Test
    void testInvalidMobileNumber_SadCase() {
        assertFalse(UserRegistration.validNumber("9897656567"));    // No country code
        assertFalse(UserRegistration.validNumber("+91-9897656567")); // Wrong format
        assertFalse(UserRegistration.validNumber("+919897656567"));  // No space
    }


    @Test
    void testValidEmail_HappyCase() {
        assertTrue(UserRegistration.validEmail("chanoey.bing@google.com"));
    }


    @Test
    void testInvalidEmail_SadCase() {
        assertFalse(UserRegistration.validEmail("chanoey.bing@.com"));
        assertFalse(UserRegistration.validEmail("chanoey@com"));
        assertFalse(UserRegistration.validEmail("chanoey.bing@@gmail.com"));
    }


    @Test
    void testValidPassword_HappyCase() {
        assertTrue(UserRegistration.validPassword("Password@123"));
    }


    @Test
    void testInvalidPassword_SadCase() {
        assertFalse(UserRegistration.validPassword("password123"));  // No uppercase, no special char
        assertFalse(UserRegistration.validPassword("PASSWORD123"));  // No lowercase, no special char
        assertFalse(UserRegistration.validPassword("Pass@12"));      // Less than 8 characters
    }


    // Parameterized Test for Multiple Email Validation
    @ParameterizedTest
    @ValueSource(strings = {
            "user@example.com",
            "chandler.bing@company.co",
            "valid.email@service.net"
    })
    void testValidEmails_Parameterized(String email) {
        assertTrue(UserRegistration.validEmail(email));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "invalid.email.com",
            "@missingusername.com",
            "user@.com",
            "user@domain..com",
            "user@domain,com"
    })
    void testInvalidEmails_Parameterized(String email) {
        assertFalse(UserRegistration.validEmail(email));
    }
}