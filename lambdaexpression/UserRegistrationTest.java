package com.bridgelabz.lambdaexpression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    private UserRegistration validator;

    @BeforeEach
    void setUp() {
        validator = new UserRegistration();
    }

    @Test
    void testValidFirstName() {
        assertDoesNotThrow(() -> validator.validFirstName("Vibhor"));
    }

    @Test
    void testInvalidFirstName() {
        Exception exception = assertThrows(InvalidUserDetailException.class, () -> validator.validFirstName("vi"));
        assertEquals("Invalid First Name: vi", exception.getMessage());
    }

    @Test
    void testValidLastName() {
        assertDoesNotThrow(() -> validator.validLastName("Gupta"));
    }

    @Test
    void testInvalidLastName() {
        Exception exception = assertThrows(InvalidUserDetailException.class, () -> validator.validLastName("g"));
        assertEquals("Invalid Last Name: g", exception.getMessage());
    }

    @Test
    void testValidEmail() {
        assertDoesNotThrow(() -> validator.validEmail("vibhor@gmail.com"));
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(InvalidUserDetailException.class, () -> validator.validEmail("invalidemail@"));
        assertEquals("Invalid Email: invalidemail@", exception.getMessage());
    }

    @Test
    void testValidPhoneNumber() {
        assertDoesNotThrow(() -> validator.validNumber("91 6574383648"));
    }

    @Test
    void testInvalidPhoneNumber() {
        Exception exception = assertThrows(InvalidUserDetailException.class, () -> validator.validNumber("657438364"));
        assertEquals("Invalid Mobile Number: 657438364", exception.getMessage());
    }

    @Test
    void testValidPassword() {
        assertDoesNotThrow(() -> validator.validPassword("Tedbhundi@1234546"));
    }

    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(InvalidUserDetailException.class, () -> validator.validPassword("pass"));
        assertEquals("Invalid Password: pass", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "mayank.pal@gmail.com", "user.name@domain.co.in"})
    void testValidEmails(String email) {
        assertDoesNotThrow(() -> validator.validEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid-email@", "plainaddress", "missing@dotcom"})
    void testInvalidEmails(String email) {
        assertThrows(InvalidUserDetailException.class, () -> validator.validEmail(email));
    }
}