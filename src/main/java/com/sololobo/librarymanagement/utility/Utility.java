package com.sololobo.librarymanagement.utility;


import com.sololobo.librarymanagement.domain.enumeration.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class Utility {

    public static boolean isValidEmail(String email) {
        if(Objects.isNull(email)){
            throw new IllegalArgumentException("Email can't be null!");
        }
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static boolean isLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(authentication) && !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
    }

    public static boolean isAdminUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Objects.nonNull(authentication) && authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.ADMIN.name()));
    }

    public static String getLoggedInUserEmail(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
