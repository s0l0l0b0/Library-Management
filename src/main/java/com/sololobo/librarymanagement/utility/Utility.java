package com.sololobo.librarymanagement.utility;


import java.util.Objects;

public class Utility {

    public static boolean isValidEmail(String email) {
        if(Objects.isNull(email)){
            throw new IllegalArgumentException("Email can't be null!");
        }
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
