package com.bridgelabz.junit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    public static boolean validFirstName(String firstName){

        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}");
        Matcher matcher = pattern.matcher(firstName);

        return matcher.matches();
    }

    public static boolean validLastName(String lastName){

        Pattern pattern = Pattern.compile("^[A-Z][a-z]{2,}");
        Matcher matcher = pattern.matcher(lastName);

        return matcher.matches();
    }

    public static boolean validEmail(String email){

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6}){1,2}$");
//        Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9])*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})(\\.[a-zA-Z]{2,3})?");
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean validPassword(String password){
        Pattern pattern = Pattern.compile("^(?=[\\w]*[\\W][\\w]*$)(?=.*[A-Z])(?=.*[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static boolean validNumber(String number){

        Pattern pattern = Pattern.compile("^([0-9]{1,2})\\s\\d{10}$");
        Matcher matcher = pattern.matcher(number);

        return matcher.matches();
    }

    public static void main(String[] args) {

        //Validate First Name
        boolean fName = validFirstName("Vibhor");
        System.out.println(fName);

        //Validate Last Name
        boolean lName = validLastName("Gupta");
        System.out.println(lName);

        //Validate Email
        boolean email = validEmail("abc.yr@gmail.com");
        System.out.println(email);

        //Validate Number
        boolean number = validNumber("91 9898989898");
        System.out.println(number);

        //Validate Password
        boolean password = validPassword("Tedbhundi@1234546");
        System.out.println(password);
    }
}
