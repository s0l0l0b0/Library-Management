package com.sololobo.librarymanagement.security;

import com.sololobo.librarymanagement.utility.Utility;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/user";
        if (Utility.isAdminUser()) {
           redirectUrl = "/admin";
        }
        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}
