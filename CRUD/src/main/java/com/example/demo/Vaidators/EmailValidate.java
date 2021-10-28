package com.example.project2.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidate {
    public static final Pattern pattern =
            Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = pattern.matcher(emailStr);
        return matcher.matches();
    }
}
