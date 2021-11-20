package com.sololobo.librarymanagement.utility;


import com.sololobo.librarymanagement.domain.BorrowLog;
import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.domain.enumeration.Role;
import com.sololobo.librarymanagement.model.BorrowLogFineDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static Integer borrowLimit(User user){
        if (user.getRole()==Role.FACULTY){
            return 5;
        }
        if (user.getRole()==Role.STUDENT){
            return 3;
        }
        return 0;
    }


    public static int calculateFine(BorrowLog borrowLog) {
        LocalDateTime dateOfBorrow = borrowLog.getDate();
        LocalDateTime now = LocalDateTime.now();
        long toDays = Duration.between(dateOfBorrow, now).toDays();
        if (toDays > 2) {
            long late = toDays - 2;
            return (int) (late * 10);
        }
        return 0;
    }


    public static BorrowLogFineDTO getBorrowLogFineDTO(BorrowLog borrowLog){

        return new BorrowLogFineDTO(borrowLog, calculateFine(borrowLog));
    }

    public static List<BorrowLogFineDTO> getBorrowLogFineDTOList(List<BorrowLog> borrowLogList){
        return borrowLogList.stream().map(Utility::getBorrowLogFineDTO).collect(Collectors.toList());
    }

}
