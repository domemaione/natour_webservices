package com.ingsoftw.v01.natour_webservices.utils;

import java.util.regex.Pattern;

public class Validation {

    public final static String regexPattern = "^(.+)@(\\S+)$";

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
