package com.bridgelabz.lambdaexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidUserDetailException extends Exception {
    public InvalidUserDetailException(String message) {
        super(message);
    }
}
public class UserRegistration {

    public static boolean validFirstName(String firstName) throws InvalidUserDetailException {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
        Matcher matcher = pattern.matcher(firstName);
        if (!matcher.matches()) {
            throw new InvalidUserDetailException("Invalid First Name: " + firstName);
        }
        return true;
    }

    public static boolean validLastName(String lastName) throws InvalidUserDetailException {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}$");
        Matcher matcher = pattern.matcher(lastName);
        if (!matcher.matches()) {
            throw new InvalidUserDetailException("Invalid Last Name: " + lastName);
        }
        return true;
    }

    public static boolean validEmail(String email) throws InvalidUserDetailException {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6}){1,2}$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidUserDetailException("Invalid Email: " + email);
        }
        return true;
    }

    public static boolean validPassword(String password) throws InvalidUserDetailException {
        Pattern pattern = Pattern.compile("^(?=[\\w]*[\\W][\\w]*$)(?=.*[A-Z])(?=.*[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            throw new InvalidUserDetailException("Invalid Password: " + password);
        }
        return true;
    }

    public static boolean validNumber(String number) throws InvalidUserDetailException {
        Pattern pattern = Pattern.compile("^([0-9]{1,2})\\s\\d{10}$");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throw new InvalidUserDetailException("Invalid Mobile Number: " + number);
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            System.out.println(validFirstName("Vibhor"));
            System.out.println(validLastName("Gupta"));
            System.out.println(validEmail("abc.yr@gmail.com"));
            System.out.println(validNumber("91 9898989898"));
            System.out.println(validPassword("Tedbhundi@1234546"));
        } catch (InvalidUserDetailException e) {
            System.out.println(e.getMessage());
        }
    }
}