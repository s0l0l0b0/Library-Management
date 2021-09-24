package com.sololobo.librarymanagement.model;

import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.domain.enumeration.Role;

public class RegistrationDTO {
    String userName;
    String email;
    Role role;
    String password1;
    //    comfirm password is password2
    String password2;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public User toUser() {
        User user = new User();
        user.setEmail(this.getEmail());
        user.setName(this.getUserName());
        user.setRole(this.getRole());
        user.setPassword(this.getPassword1());
        return user;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password1='" + password1 + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
