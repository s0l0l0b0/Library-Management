package com.sololobo.librarymanagement.security;

import com.sololobo.librarymanagement.domain.User;
import com.sololobo.librarymanagement.domain.enumeration.Role;
import com.sololobo.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    private Set<GrantedAuthority> getGrantedAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Role.ADMIN.equals(user.getRole())) {
            for (Role role : Role.values()) {
                authorities.add(new SimpleGrantedAuthority(role.name()));
            }
            authorities.add(new SimpleGrantedAuthority(Role.STUDENT.name()));
            authorities.add(new SimpleGrantedAuthority(Role.FACULTY.name()));
        }
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String userIdValue) throws UsernameNotFoundException {
        Long userId = Long.valueOf(userIdValue);
        Optional<User> userOp = userRepository.findById(userId);
        if (userOp.isPresent()) {
            User user = userOp.get();
            return new org.springframework.security.core.userdetails.User(userIdValue, user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
        }
        return null;
    }
}